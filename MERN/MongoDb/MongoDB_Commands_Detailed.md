# 🛠️ MongoDB Commands with Use Cases, Outputs & Debugging Tips

## 1. `mongo`
**Command:** `mongo`  
**Use:** Connects to MongoDB shell.  
**Output:**
```
MongoDB shell version v6.0.3
connecting to: mongodb://127.0.0.1:27017/
```
**Debug Tip:** If connection fails, check MongoDB service status.

## 2. `show dbs`
**Use:** Lists all databases.  
**Output:**
```
admin   0.000GB
config  0.000GB
local   0.000GB
```
**Debug Tip:** Databases only show if they contain data.

## 3. `use dbName`
**Use:** Switches to or creates a database.  
**Output:** `switched to db testDB`  
**Debug Tip:** Database not listed in `show dbs` until data is added.

## 4. `db`
**Use:** Returns current database name.  
**Output:** `testDB`

## 5. `db.dropDatabase()`
**Use:** Deletes current database.  
**Output:** `{ "ok" : 1 }`  
**Debug Tip:** Ensure correct DB with `db` before deleting.

## 6. `db.createCollection("name")`
**Use:** Creates a collection.  
**Output:** `{ "ok" : 1 }`  
**Debug Tip:** Not necessary unless setting special options.

## 7. `show collections`
**Use:** Lists collections in the current DB.

## 8. `db.COLLECTION.insertOne({...})`
**Use:** Inserts one document.  
**Output:** `{ "acknowledged": true, "insertedId": ObjectId("...") }`

## 9. `db.COLLECTION.insertMany([...])`
**Use:** Inserts multiple documents.  
**Output:** `acknowledged: true, insertedIds: { ... }`  
**Debug Tip:** Ensure all documents are valid JSON.

## 10. `db.COLLECTION.find({ query })`
**Use:** Fetch documents.  
**Output:** JSON documents matching query.  
**Debug Tip:** Use `.pretty()` to format output.

## 11. `db.COLLECTION.updateOne(filter, update)`
**Use:** Updates first matched document.  
**Output:** `matchedCount`, `modifiedCount`  
**Debug Tip:** Always use `$set` operator.

## 12. `db.COLLECTION.updateMany(filter, update)`
**Use:** Updates all matched documents.

## 13. `db.COLLECTION.deleteOne({filter})`
**Use:** Deletes one document.  
**Output:** `deletedCount`

## 14. `db.COLLECTION.deleteMany({filter})`
**Use:** Deletes all matched documents.

## 15. `db.COLLECTION.countDocuments()`
**Use:** Returns document count.  
**Output:** Integer

## 16. `db.COLLECTION.sort({field: 1 or -1})`
**Use:** Sorts documents by field.

## 17. `db.COLLECTION.limit(n)`
**Use:** Limits result count.

## 18. `db.COLLECTION.aggregate([...])`
**Use:** Aggregation operations like avg, sum, group etc.

## 19. `db.COLLECTION.createIndex({ field: 1 })`
**Use:** Creates an index.  
**Output:** Index name

## 20. `db.COLLECTION.getIndexes()`
**Use:** Lists all indexes.

## 21. `db.COLLECTION.dropIndex("index_name")`
**Use:** Drops specified index.

## 🧪 Common Debugging Scenarios

| Problem | Cause | Solution |
|--------|--------|----------|
| `show dbs` shows no DB | DB is empty | Insert a document first |
| Cannot connect `mongo` | MongoDB service stopped | `sudo service mongod start` |
| Duplicate `_id` error | Inserting existing `_id` | Remove `_id` or use unique ones |
| Updates not working | Forgot `$set` | Always use modifier operators |
| Query returns nothing | Wrong field/value | Check data with `find()` |