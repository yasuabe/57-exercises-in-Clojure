; Ex4: Mad Lib
; ・ Prompt the user to enter a noun, a verb, an adjective, and an adverb.
; ・ Create a story using the inputs.
; ・ Use string interpolation or substitution to build the output.
; ・ Use a single output statement to display the story.

(ns ex04.core)

(defn prompt-read [prompt]
  (print prompt)
  (flush)
  (read-line))

(defn -main [& _]
  (let [n   (prompt-read "Enter a noun: ")
        v   (prompt-read "Enter a verb: ")
        adj (prompt-read "Enter an adjective: ")
        adv (prompt-read "Enter an adverb: ")

        sentence (format "Do you %s your %s %s %s? That's hilarious!" v adj n adv)]
    (println sentence)))
