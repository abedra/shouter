(ns shouter.models.base
  (:require [clojure.string :as str]
            [clojure.java.jdbc :as sql])
  (:import (java.net URI)))

(defn database-resource []
  (let [url (URI. (or (System/getenv "DATABASE_URL") nil))
        user-info (str/split (.getUserInfo url) #":")
        database-name (last (str/split (str url) #"/"))]
    {:username (first user-info)
     :password (second user-info)
     :subname (str "//" (.getHost url) ":5432/" database-name)}))

(let [resource (database-resource)]
  (def db {:classname "org.postgresql.Driver"
           :subprotocol "postgresql"
           :subname (:subname resource)
           :username (:username resource)
           :password (:password resource)}))
