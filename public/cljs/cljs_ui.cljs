(ns cljs-ui
  (:require
    [reagent.core :as r]
    [reagent.dom :as rdom]
    [clojure.set :as set]))


(defn item [title & {:keys [active? body] :or {active? false}}]
  [(if active? :div.carousel-item.active :div.carousel-item)
   (cond-> [:svg.bd-placeholder-img.bd-placeholder-img-lg.d-block.w-100
            {:width "800" :height "100vh" :xmlns "http://www.w3.org/2000/svg"
             :role  "img" :preserveAspectRatio "xMidYMid slice" :focusable "false"}
            [:title title]
            [:rect {:width "100%" :height "100%" :fill "#ffe7e5"}]]
           body (concat body)
           :always (vec))])


(defn title-page [title]
  [item title
   :active? true?
   :body [[:text {:x "50%" :y "50%" :fill "#555" :dy ".3em"} title]]])


(defn slide [heading & {:keys [lines footer active?] :or {active? false}}]
  (let [pcts         (range 30 80 (quot 60 (count lines)))
        text-items   (mapv (fn [pct-y item]
                             [:text {:x "50%" :y (str pct-y "%") :fill "#555" :dy ".3em"} item])
                           pcts lines)
        header+items (concat [[:text {:x "50%" :y "10%" :fill "#000" :dy ".3em"} heading]]
                             text-items)
        item         [:div.carousel-item
                      (vec (concat [:svg.bd-placeholder-img.bd-placeholder-img-lg.d-block.w-100
                                    {:width "800" :height "100vh" :xmlns "http://www.w3.org/2000/svg"
                                     :role  "img" :preserveAspectRatio "xMidYMid slice" :focusable "false"}
                                    [:title heading]
                                    [:rect {:width "100%" :height "100%" :fill "#ffe7e5"}]]
                                   header+items))
                      (and footer)]]
    item))


(defn slides []
  [:div#slides.carousel.carousel-dark.slide
   [:div.carousel-inner
    [title-page "nbb Lambdas"]
    [slide "Agenda"
     :lines ["What is nbb?"
             "Local dev"
             "AWS Lambdas"]]
    [slide "nbb in brief"
     :lines ["CLJS interpreter for nodejs \uD83D\uDDE3️"
             "No packaging required \uD83E\uDDE0"
             "SCI is used to do the heavy lifting \uD83C\uDFCB️\u200D♀️"]
     :footer
     [:div.carousel-caption.d-none.d-md-block
      [:h3 "nodejs starts fast and has a prodigious standard library"]
      [:h5 "A small suite of curated packages are shipped with nbb including promesa, cljs-bean"]]]]
   [:button.carousel-control-prev {:type "button" :data-bs-target "#slides" :data-bs-slide "prev"}
    [:span.carousel-control-prev-icon]
    [:span.visually-hidden "Previous"]]
   [:button.carousel-control-next {:type "button" :data-bs-target "#slides" :data-bs-slide "next"}
    [:span.carousel-control-next-icon]
    [:span.visually-hidden "Next"]]])


(defn home-page
  []
  [:div.m-0.border-0
   [slides]])


(rdom/render [home-page] (js/document.getElementById "app"))
