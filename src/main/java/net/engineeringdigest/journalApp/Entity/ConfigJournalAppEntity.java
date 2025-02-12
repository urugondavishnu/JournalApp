package net.engineeringdigest.journalApp.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


//@Getter
//@Setter
@Document(collection = "config_journal_app")// says this class is a MongoDB mapping entity
@Data
@NoArgsConstructor
public class ConfigJournalAppEntity {
    private String key;
    private String value;
}
