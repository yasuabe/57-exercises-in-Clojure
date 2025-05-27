(ns ex52.client
  (:require [org.httpkit.client :as http]
            [cheshire.core :as json]
            [java-time :as jt])
  (:import [java.util Locale]
           [java.time.format DateTimeFormatter]))

(def month-name-of
  (DateTimeFormatter/ofPattern "MMMM"
                               (Locale/forLanguageTag "en-US")))
(defn -main []
  (let [{:keys [body]} @(http/get "http://localhost:8080/ex52/time")
        {:strs [currentTime]} (json/parse-string body)
        parsed-time (jt/local-date-time "yyyy-MM-dd HH:mm:ss" currentTime)
        formatted (format "The current time is %s UTC %s %d %d."
                          (jt/format "HH:mm:ss" parsed-time)
                          (jt/format month-name-of parsed-time)
                          (jt/as parsed-time :day-of-month)
                          (jt/as parsed-time :year))]
    (println formatted)))
