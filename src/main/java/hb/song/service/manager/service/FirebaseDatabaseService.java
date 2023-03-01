package hb.song.service.manager.service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import hb.song.service.manager.constant.FirebaseConnector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FirebaseDatabaseService {

  private final FirebaseConnector connector;

  public void insertValue(String value) {
    FirebaseDatabase database = FirebaseDatabase.getInstance(connector.getFirebaseApp());

    DatabaseReference reference = database.getReference("/user");
    reference.setValueAsync(value);
  }
}
