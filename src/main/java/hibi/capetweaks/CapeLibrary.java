package hibi.capetweaks;

import java.util.HashMap;
import java.util.Map;

import hibi.SimpleConfig;

public final class CapeLibrary {

	public static final String
		// Mojang Capes
		MOJANG_OLD =         "/8f120319222a9f4a104e2f5cb97b2cda93199a2ee9e1585cb8d09d6f687cb761",
		MOJANG =             "/5786fe99be377dfb6858859f926c4dbc995751e91cee373468c5fbf4865e7151",
		MOJANG_NEW =         "/9e507afc56359978a3eb3e32367042b853cddd0995d17d0da995662913fb00f7",
		// Minecon Capes
		MINECON_2011 =       "/953cac8b779fe41383e675ee2b86071a71658f2180f56fbce8aa315ea70e2ed6",
		MINECON_2012 =       "/a2e8d97ec79100e90a75d369d1b3ba81273c4f82bc1b737e934eed4a854be1b6",
		MINECON_2013 =       "/153b1a0dfcbae953cdeb6f2c2bf6bf79943239b1372780da44bcbb29273131da",
		MINECON_2015 =       "/b0cc08840700447322d953a02b965f1d65a13a603bf64b17c803c21446fe1635",
		MINECON_2016 =       "/e7dfea16dc83c97df01a12fabbd1216359c0cd0ea42f9999b6e97c584963e980",
		MINECON_2023 =       "/unknown",
		// Personal Capes
		MILLIONTH_SALE =     "/70efffaf86fe5bc089608d3cb297d3e276b9eb7a8f9f2fe6659c23a2d8b18edf",
		DANNYBSTYLE =        "/bcfbe84c6542a4a5c213c1cacf8979b5e913dcb4ad783a8b80e3c4a7d5c8bdac",
		JULIANCLARK =        "/23ec737f18bfe4b547c95935fc297dd767bb84ee55bfd855144d279ac9bfd9fe",
		CHEAPSHOT =          "/ca29f5dd9e94fb1748203b92e36b66fda80750c87ebc18d6eafdb0e28cc1d05f",
		MRMESSIAH =          "/2e002d5e1758e79ba51d08d92a0f3a95119f2f435ae7704916507b6c565a7da8",
		PRISMARINE =         "/d8f8d13a1adf9636a16c31d47f3ecc9bb8d8533108aa5ad2a01b13b1a0c55eac",
		TURTLE =             "/5048ea61566353397247d2b7d946034de926b997d5e66c86483dfb1e031aee95",
		BIRTHDAY =           "/2056f2eebd759cce93460907186ef44e9192954ae12b227d817eb4b55627a7fc",
		// Translator Capes
		TRANSLATOR =         "/1bf91499701404e21bd46b0191d63239a4ef76ebde88d27e4d430ac211df681e",
		TRANSLATOR_CHINESE = "/2262fb1d24912209490586ecae98aca8500df3eff91f2a07da37ee524e7e3cb6",
		// Community Reward Capes
		SCROLLS_CHAMP =      "/3efadf6510961830f9fcc077f19b4daf286d502b5f5aafbd807c7bbffcaca245",
		COBALT =             "/ca35c56efe71ed290385f4ab5346a1826b546a54d519e6a3ff01efa01acce81",
		MODERATOR =          "/ae677f7d98ac70a533713518416df4452fe5700365c09cf45d0d156ea9396551",
		MAP_MAKER =          "/17912790ff164b93196f08ba71d0e62129304776d0f347334f8a6eae509f8a56",
		// Freebies
		MIGRATOR =           "/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933";

	public static final Map<String,Boolean> db = new HashMap<String,Boolean>();

	public static boolean isShown(String url) {
		for (String i : db.keySet()) {
			if(url.endsWith(i)) {
				return db.get(i);
			}
		}
		return true;
	}

	public static void init(SimpleConfig config) {
		 db.put(MOJANG_OLD, config.getOrDefault("cape:mojang_old", true));
		 db.put(MOJANG, config.getOrDefault("cape:mojang", true));
		 db.put(MOJANG_NEW, config.getOrDefault("cape:mojang_new", true));
		 db.put(MINECON_2011, config.getOrDefault("cape:minecon_2011", true));
		 db.put(MINECON_2012, config.getOrDefault("cape:minecon_2012", true));
		 db.put(MINECON_2013, config.getOrDefault("cape:minecon_2013", true));
		 db.put(MINECON_2015, config.getOrDefault("cape:minecon_2015", true));
		 db.put(MINECON_2016, config.getOrDefault("cape:minecon_2016", true));
		 db.put(MINECON_2023, config.getOrDefault("cape:minecon_2023", true));
		 db.put(MILLIONTH_SALE, config.getOrDefault("cape:millionth_sale", true));
		 db.put(DANNYBSTYLE, config.getOrDefault("cape:dannybstyle", true));
		 db.put(JULIANCLARK, config.getOrDefault("cape:julianclark", true));
		 db.put(CHEAPSHOT, config.getOrDefault("cape:cheapsh0t", true));
		 db.put(MRMESSIAH, config.getOrDefault("cape:mrmessiah", true));
		 db.put(PRISMARINE, config.getOrDefault("cape:prismarine", true));
		 db.put(TURTLE, config.getOrDefault("cape:turtle", true));
		 db.put(BIRTHDAY, config.getOrDefault("cape:birthday", true));
		 db.put(TRANSLATOR, config.getOrDefault("cape:translator", true));
		 db.put(TRANSLATOR_CHINESE, config.getOrDefault("cape:translator_chinese", true));
		 db.put(MAP_MAKER, config.getOrDefault("cape:map_maker", true));
		 db.put(SCROLLS_CHAMP, config.getOrDefault("cape:scrolls_champ", true));
		 db.put(COBALT, config.getOrDefault("cape:cobalt", true));
		 db.put(MODERATOR, config.getOrDefault("cape:moderator", true));
		 db.put(MIGRATOR, config.getOrDefault("cape:migrator", true));
	}

	public static void save(SimpleConfig config) {
		config.put("cape:mojang_old", db.get(MOJANG_OLD));
		config.put("cape:mojang", db.get(MOJANG));
		config.put("cape:mojang_new", db.get(MOJANG_NEW));
		config.put("cape:minecon_2011", db.get(MINECON_2011));
		config.put("cape:minecon_2012", db.get(MINECON_2012));
		config.put("cape:minecon_2013", db.get(MINECON_2013));
		config.put("cape:minecon_2015", db.get(MINECON_2015));
		config.put("cape:minecon_2016", db.get(MINECON_2016));
		config.put("cape:minecon_2023", db.get(MINECON_2023));
		config.put("cape:millionth_sale", db.get(MILLIONTH_SALE));
		config.put("cape:dannybstyle", db.get(DANNYBSTYLE));
		config.put("cape:julianclark", db.get(JULIANCLARK));
		config.put("cape:cheapsh0t", db.get(CHEAPSHOT));
		config.put("cape:mrmessiah", db.get(MRMESSIAH));
		config.put("cape:prismarine", db.get(PRISMARINE));
		config.put("cape:turtle", db.get(TURTLE));
		config.put("cape:birthday", db.get(BIRTHDAY));
		config.put("cape:translator", db.get(TRANSLATOR));
		config.put("cape:translator_chinese", db.get(TRANSLATOR_CHINESE));
		config.put("cape:scrolls_champ", db.get(SCROLLS_CHAMP));
		config.put("cape:cobalt", db.get(COBALT));
		config.put("cape:moderator", db.get(MODERATOR));
		config.put("cape:migrator", db.get(MIGRATOR));
	}

	private CapeLibrary() {
	}
}
