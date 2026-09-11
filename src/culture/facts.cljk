(ns culture.facts
  "Regional-culture catalog for Jakarta -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto this
  municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"jakarta"
   [{:culture/id "jakarta.dish.kerak-telor"
     :culture/name "Kerak telor"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :dish
     :culture/summary "Betawi traditional spicy omelette dish of glutinous rice and egg, originating from Greater Jakarta in the Dutch colonial era."
     :culture/url "https://en.wikipedia.org/wiki/Kerak_telor"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.dish.soto-betawi"
     :culture/name "Soto Betawi"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :dish
     :culture/summary "Soup of beef or beef offal cooked in cow-milk or coconut-milk broth with fried potato and tomato, originating from Jakarta."
     :culture/url "https://en.wikipedia.org/wiki/Soto_Betawi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.dish.gado-gado"
     :culture/name "Gado-gado"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :dish
     :culture/summary "Indonesian salad of vegetables with peanut sauce, prevalent in Western Java including Jakarta; its exact origin is debated among Sundanese, Betawi and other influences."
     :culture/url "https://en.wikipedia.org/wiki/Gado-gado"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.dish.nasi-uduk"
     :culture/name "Nasi uduk"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :dish
     :culture/summary "Indonesian steamed rice cooked in coconut milk, especially popular in Betawi and Javanese culinary traditions and common breakfast fare in Jakarta kampungs."
     :culture/url "https://en.wikipedia.org/wiki/Nasi_uduk"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.beverage.bir-pletok"
     :culture/name "Bir pletok"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :beverage
     :culture/summary "Non-alcoholic Indonesian drink of the Betawi people in Jakarta, made from ginger, pandan leaves, sappan wood and lemongrass."
     :culture/url "https://en.wikipedia.org/wiki/Bir_pletok"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.craft.ondel-ondel"
     :culture/name "Ondel-ondel"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :craft
     :culture/summary "Large puppet figure (about 2.5 m tall, bamboo body, wooden head) featured in Betawi folk performance, an iconic symbol of Jakarta used in festivals and ceremonial events."
     :culture/url "https://en.wikipedia.org/wiki/Ondel-ondel"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.festival.jakarta-fair"
     :culture/name "Jakarta Fair"
     :culture/name-local "Pekan Raya Jakarta"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :festival
     :culture/summary "Annual fair held at Jakarta International Expo in Kemayoran, part of a series of events celebrating the capital's anniversary on June 22."
     :culture/url "https://en.wikipedia.org/wiki/Jakarta_Fair"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.heritage.kota-tua"
     :culture/name "Jakarta Old Town"
     :culture/name-local "Kota Tua Jakarta"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :heritage
     :culture/summary "Neighborhood comprising the original downtown area of Jakarta, with Dutch-style structures mostly from the 17th century when the port city was the Asian headquarters of the VOC."
     :culture/url "https://en.wikipedia.org/wiki/Kota_Tua_Jakarta"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "jakarta.heritage.national-monument"
     :culture/name "National Monument"
     :culture/name-local "Monumen Nasional"
     :culture/municipality "jakarta"
     :culture/country "IDN"
     :culture/kind :heritage
     :culture/summary "132 m obelisk in the centre of Merdeka Square, Central Jakarta, built to commemorate Indonesia's struggle for independence."
     :culture/url "https://en.wikipedia.org/wiki/National_Monument_(Indonesia)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-idn-jakarta culture catalog "
                 "(ADR-2607171400): " (count (get catalog "jakarta"))
                 " Jakarta entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
