import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import cloud.metaapi.sdk.MetaStats;
import cloud.metaapi.sdk.clients.MetaStatsClient.Metrics;
import cloud.metaapi.sdk.clients.meta_api.models.MetatraderAccountDto.ConnectionStatus;
import cloud.metaapi.sdk.clients.meta_api.models.MetatraderAccountDto.DeploymentState;
import cloud.metaapi.sdk.meta_api.MetaApi;
import cloud.metaapi.sdk.meta_api.MetatraderAccount;
import cloud.metaapi.sdk.util.JsonMapper;

public class MetaStatsExample {

  // your MetaApi API token
  private static String token = getEnvOrDefault("TOKEN", "<put in your token here>");
  // your MetaApi account id
  private static String accountId = getEnvOrDefault("ACCOUNT_ID", "<put in your MetaApi account id here>");
   
  public static void main(String[] args) throws IOException {
    MetaApi api = new MetaApi(token);
    MetaStats metaStats = new MetaStats(token);
    // you can configure http client via second parameter,
    // see javadoc in-code documentation for full definition of possible configuration options
    
    try {
      MetatraderAccount account = api.getMetatraderAccountApi().getAccount(accountId).join();

      // wait until account is deployed and connected to broker
      System.out.println("Deploying account");
      if (account.getState() != DeploymentState.DEPLOYED) {
        account.deploy().join();
      } else {
        System.out.println("Account already deployed");
      }
      System.out.println("Waiting for API server to connect to broker (may take couple of minutes)");
      if (account.getConnectionStatus() != ConnectionStatus.CONNECTED) {
        account.waitConnected().join();
      }
      
      Metrics metrics = metaStats.getMetrics(accountId).join();
      String jsonMetrics = asJson(metrics); //-> {trades: ..., balance: ..., ...}
      System.out.println(jsonMetrics.substring(0, Math.min(200, jsonMetrics.length())));
    } catch (Exception err) {
      err.printStackTrace();
    }
    System.exit(0);
  }
   
  private static String getEnvOrDefault(String name, String defaultValue) {
    String result = System.getenv(name);
    return (result != null ? result : defaultValue);
  }

  private static String asJson(Object object) throws JsonProcessingException {
    return JsonMapper.getInstance().writeValueAsString(object);
  }
}