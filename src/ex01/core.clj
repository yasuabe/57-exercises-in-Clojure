; Ex1: Saying Hello
;
;・Prompt the user to enter their name.
;・Create a greeting message using string concatenation.
;・Print the greeting.
;・Keep input, concatenation, and output as separate steps.

(ns ex01.core)

(defn -main [& _]
  (print "What is your name? ")
  (flush)
  (let [name (read-line)
        greeting (str "Hello, " name ", nice to meet you!")]
    (println greeting)))
