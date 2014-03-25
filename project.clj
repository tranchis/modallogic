(defproject modallogic "0.0.1"
  :description "An advanced example of how to use lein-cljsbuild"
  :source-paths  ["src"]
  :jvm-opts ^:replace  ["-Xms1024m" "-Xmx1024m" "-server"]
  :dependencies  [[org.clojure/clojure "1.5.1"]
                  [org.clojure/clojurescript "0.0-2120"
                   :exclusions  [org.apache.ant/ant]]
                  [prismatic/dommy "0.1.1"]
                  [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                  [cljs-http "0.1.1"]
                  [cljs-ajax "0.2.2"]
                  [markdown-clj "0.9.40"]
                  [jayq "2.5.0"]
                  [com.andrewmcveigh/cljs-time "0.1.1"]]
  :plugins  [[lein-cljsbuild "1.0.1"]
             [no-man-is-an-island/lein-eclipse "2.0.0"]]
  :hooks  [leiningen.cljsbuild]
  :cljsbuild  {
               :repl-listen-port 9000
               :repl-launch-commands
               {"firefox"  ["firefox"
                            :stdout ".repl-firefox-out"
                            :stderr ".repl-firefox-err"]
                "firefox-naked"  ["firefox"
                                  "resources/private/html/naked.html"
                                  :stdout ".repl-firefox-naked-out"
                                  :stderr ".repl-firefox-naked-err"]
                "phantom"  ["phantomjs"
                            "phantom/repl.js"
                            :stdout ".repl-phantom-out"
                            :stderr ".repl-phantom-err"]
                "phantom-naked"  ["phantomjs"
                                  "phantom/repl.js"
                                  "resources/private/html/naked.html"
                                  :stdout ".repl-phantom-naked-out"
                                  :stderr ".repl-phantom-naked-err"]}
               :test-commands
               {"unit"  ["phantomjs"
                         "phantom/unit-test.js"
                         "resources/private/html/unit-test.html"]}
               :crossovers  []
               :crossover-jar true
               :builds  {
                         :dev
                         {:source-paths  ["src"]
                          :jar true
                          :compiler  {:output-to "resources/public/js/main-debug.js"
                                      :optimizations :whitespace
                                      :pretty-print true}}
                         :prod
                         {:source-paths  ["src"]
                          :compiler
                          {:output-to "resources/public/js/main.js"
                           :externs  []
                           :optimizations :simple
                           :pretty-print false}}}})
