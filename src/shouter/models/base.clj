(ns shouter.models.base
  (:require [clojure.string :as str]
            [clojure.java.jdbc :as sql])
  (:import (java.net URI)))

(defn database-resource []
  (let [url (URI. (System/getenv "DATABASE_URL"))
        host (.getHost url)
        port (if (pos? (.getPort url)) (.getPort url) 5432)
        path (.getPath url)]
    (merge
      {:subname (str "//" host ":" port path)}
      (if-let [user-info (.getUserInfo url)]
        {:user (first (str/split user-info #":"))
         :password (second (str/split user-info #":"))}))))

(def db
  (merge
    {:classname "org.postgresql.Driver"
     :subprotocol "postgresql"}
    (database-resource)))
