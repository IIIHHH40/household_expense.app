package haruto;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class SecretsUtil {
    public static String getSecret(String secretName) {
    System.out.println("SecretsUtil: building client");
    SecretsManagerClient client = SecretsManagerClient.builder()
            .region(software.amazon.awssdk.regions.Region.AP_NORTHEAST_1)
            .build();

    System.out.println("SecretsUtil: before getSecretValue");
    GetSecretValueRequest req = GetSecretValueRequest.builder()
            .secretId(secretName)
            .build();

    GetSecretValueResponse res = client.getSecretValue(req);
    System.out.println("SecretsUtil: after getSecretValue");

    return res.secretString();
}

    
}
