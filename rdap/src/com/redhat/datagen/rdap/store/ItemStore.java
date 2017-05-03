package com.redhat.datagen.rdap.store;

import java.util.List;

public final class ItemStore implements DomainObjectStore {

    private static final ItemStore SHARED = new ItemStore();

    public static List< String > getItems( final String fileName ) throws Exception {
        return SHARED.load( fileName );
    }

    /**
     * Don't allow construction outside of this class.
     */
    private ItemStore() {
        // nothing to do
    }

}
