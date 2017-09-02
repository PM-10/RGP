package com.pm10.rgptest.db;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmProvider {
    private static RealmProvider realmProvider;

    public static RealmProvider getInstance() {
        if (realmProvider == null)
            realmProvider = new RealmProvider();

        return realmProvider;
    }

    public Realm getRealm() {
        return Realm.getDefaultInstance();
    }

    public <T> void writeData(ArrayList<T> items) {
        try (Realm realm = getRealm()) {

            realm.beginTransaction();
            for (T item : items) {
                realm.copyToRealmOrUpdate((RealmObject) item);
            }
            realm.commitTransaction();
        }
    }

    public <T> void writeData(T item) {
        try (Realm realm = getRealm()) {

            realm.beginTransaction();
            realm.copyToRealmOrUpdate((RealmObject) item);

            realm.commitTransaction();
        }
    }

    public <T extends Class> RealmResults findAllData(T t) {
        Realm realm = getRealm();
        return realm.where(t).findAllAsync();
    }

    public <T extends Class> RealmObject findData(T t, String field, int value) {
        try (Realm realm = getRealm()) {

            RealmObject object = (RealmObject) realm.where(t).equalTo(field, value).findFirst();
            return object;
        }

    }

    public <T extends Class> void deleteData(T t, String field, int value) {
        try (Realm realm = getRealm()) {

            RealmResults results = realm.where(t).equalTo(field, value).findAll();

            realm.executeTransaction(realm1 -> {
                results.deleteFirstFromRealm();
            });
        }
    }

    public void closeRealm(Realm realm) {
        if (realm == null || realm.isClosed())
            return;

        realm.close();
    }

}
