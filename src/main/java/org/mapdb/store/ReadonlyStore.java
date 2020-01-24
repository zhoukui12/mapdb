package org.mapdb.store;

import org.mapdb.ser.Serializer;

public interface ReadonlyStore extends Closable {


    /**
     * Get existing record
     *
     * @return record or null if record was not allocated yet, or was deleted
     **/
    <K> K get(long recid, Serializer<K> ser);

    void close();

    /**
     * Iterates over all records in store.
     *
     * Function takes recid and binary data
     */
    void getAll(GetAllCallback callback);

    interface GetAllCallback{
        void takeOne(long recid, byte[] data);
    }

    /**
     * Returns true if store does not contain any data and no recids were allocated yet.
     * Store is usually empty just after creation.
     */
    boolean isEmpty();

}
