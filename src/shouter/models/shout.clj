(ns shouter.models.shout
  (:use [shouter.models.base :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/with-connection db
    (sql/with-query-results results
      ["select * from shouts order by id desc"]
      (into [] results))))

(defn create [shout]
  (sql/with-connection db
    (sql/insert-values :shouts [:body] [shout])))
