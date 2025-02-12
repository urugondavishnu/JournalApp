package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {
// JournalEntry is the entity and String is the typeof ID

}
