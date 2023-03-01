package hb.song.service.manager.constant;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import java.io.IOException;
import java.io.InputStream;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirebaseConnector {

  @Getter
  private FirebaseApp firebaseApp;

  public FirebaseConnector() {
    try {
      ClassPathResource tokenResource = new ClassPathResource(
        "constant/4242-service-manager-admin-key.json");
      InputStream is = tokenResource.getInputStream();
      FirebaseOptions.Builder builder = FirebaseOptions.builder();

      builder
        .setCredentials(GoogleCredentials.fromStream(is))
        .setDatabaseUrl(
          "https://service-manager-4242-default-rtdb.asia-southeast1.firebasedatabase.app");

      firebaseApp = FirebaseApp.initializeApp(builder.build());

    } catch (IOException e) {
      firebaseApp = null;
      log.error("Can't get admin key can't start application...", e);
      System.exit(-1111);
    }
  }
}
