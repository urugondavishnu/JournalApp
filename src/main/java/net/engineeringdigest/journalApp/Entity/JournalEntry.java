package net.engineeringdigest.journalApp.Entity;

import lombok.*;
import net.engineeringdigest.journalApp.enums.Sentiments;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


//@Getter
//@Setter
@Document(collection = "journal_entries")// says this class is a MongoDB mapping entity
@Data
@NoArgsConstructor
public class JournalEntry {
    @Id // Pointing a unique key in the collections
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
    private Sentiments sentiments;
}
