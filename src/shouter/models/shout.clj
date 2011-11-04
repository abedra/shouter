(ns shouter.models.shout
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/with-query-results results
      ["select * from shouts order by id desc"]
      (into [] results))))

(defn create [shout]
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/insert-values :shouts [:body] [shout])))
