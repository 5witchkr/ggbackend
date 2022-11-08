package com.pickban.ggbackend.recommendpick.domain;


import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockDataSave {
    private final ChampionRepository championRepository;

    public void saveTestData() {
        if (championRepository.existsById(1L)) return;
        //                "Aatrox": "266",
        championRepository.save(new Champion(266L, "Aatrox", "top", "1Tier", 96L, List.of()));
        //                "Ahri": "103",
        championRepository.save(new Champion(103L, "Ahri", "mid", "1Tier", 95L, List.of()));
        //                "Akali": "84",
        championRepository.save(new Champion(84L, "Ahri", "mid", "2Tier", 85L, List.of()));
        //                "Akshan": "166",
        championRepository.save(new Champion(166L, "Akshan", "mid", "3Tier", 71L, List.of()));
        //                "Alistar": "12",
        championRepository.save(new Champion(12L, "Alistar", "sup", "4Tier", 51L, List.of()));
        //                "Amumu": "32",
        championRepository.save(new Champion(32L, "Amumu", "sup", "2Tier", 81L, List.of()));
//                "Anivia": "34",
        championRepository.save(new Champion(34L, "Anivia", "mid", "2Tier", 81L, List.of()));
//                "Annie": "1",
        championRepository.save(new Champion(1L, "Annie", "mid", "5Tier", 31L, List.of()));
//                "Aphelios": "523",
        championRepository.save(new Champion(523L, "Aphelios", "adc", "4Tier", 71L, List.of()));
//                "Ashe": "22",
        championRepository.save(new Champion(22L, "Ashe", "adc", "2Tier", 81L, List.of()));
//                "AurelionSol": "136",
        championRepository.save(new Champion(136L, "AurelionSol", "mid", "6Tier", 11L, List.of()));
//                "Azir": "268",
        championRepository.save(new Champion(268L, "Azir", "mid", "4Tier", 77L, List.of()));
//                "Bard": "432",
        championRepository.save(new Champion(432L, "Bard", "sup", "4Tier", 64L, List.of()));
//                "Belveth": "200",
        championRepository.save(new Champion(200L, "Belveth", "jg", "1Tier", 98L, List.of()));
//                "Blitzcrank": "53",
        championRepository.save(new Champion(53L, "Blitzcrank", "sup", "1Tier", 95L, List.of()));
//                "Brand": "63",
        championRepository.save(new Champion(63L, "Brand", "sup", "4Tier", 65L, List.of()));
//                "Braum": "201",
        championRepository.save(new Champion(201L, "Braum", "sup", "4Tier", 70L, List.of()));
//                "Caitlyn": "51",
        championRepository.save(new Champion(51L, "Caitlyn", "adc", "1Tier", 92L, List.of()));
//                "Camille": "164",
        championRepository.save(new Champion(164L, "Camille", "top", "1Tier", 94L, List.of()));
//                "Cassiopeia": "69",
        championRepository.save(new Champion(69L, "Cassiopeia", "mid", "3Tier", 81L, List.of()));
//                "Chogath": "31",
        championRepository.save(new Champion(31L, "Chogath", "top", "4Tier", 75L, List.of()));
//                "Corki": "42",
        championRepository.save(new Champion(42L, "Corki", "mid", "5Tier", 74L, List.of()));
//                "Darius": "122",
        championRepository.save(new Champion(122L, "Darius", "top", "1Tier", 100L, List.of()));
//                "Diana": "131",
        championRepository.save(new Champion(131L, "Diana", "jg", "2Tier", 87L, List.of()));
//                "Draven": "119",
        championRepository.save(new Champion(119L, "Draven", "adc", "2Tier", 90L, List.of()));
//                "DrMundo": "36",
        championRepository.save(new Champion(36L, "DrMundo", "top", "3Tier", 87L, List.of()));
//                "Ekko": "245",
        championRepository.save(new Champion(245L, "Ekko", "jg", "2Tier", 89L, List.of()));
//                "Elise": "60",
        championRepository.save(new Champion(60L, "Elise", "jg", "1Tier", 94L, List.of()));
//                "Evelynn": "28",
        championRepository.save(new Champion(28L, "Evelynn", "jg", "2Tier", 88L, List.of()));
//                "Ezreal": "81",
        championRepository.save(new Champion(81L, "Ezreal", "adc", "2Tier", 90L, List.of()));
//                "Fiddlesticks": "9",
        championRepository.save(new Champion(9L, "Fiddlesticks", "jg", "1Tier", 90L, List.of()));
//                "Fiora": "114",
        championRepository.save(new Champion(114L, "Fiora", "top", "2Tier", 93L, List.of()));
//                "Fizz": "105",
        championRepository.save(new Champion(105L, "Fizz", "mid", "3Tier", 73L, List.of()));
//                "Galio": "3",
        championRepository.save(new Champion(3L, "Galio", "mid", "3Tier", 75L, List.of()));
//                "Gangplank": "41",
        championRepository.save(new Champion(41L, "Gangplank", "top", "2Tier", 80L, List.of()));
//                "Garen": "86",
        championRepository.save(new Champion(86L, "Garen", "top", "2Tier", 89L, List.of()));
//                "Gnar": "150",
        championRepository.save(new Champion(150L, "Gnar", "top", "3Tier", 88L, List.of()));
//                "Gragas": "79",
        championRepository.save(new Champion(79L, "Gragas", "top", "4Tier", 85L, List.of()));
//                "Graves": "104",
        championRepository.save(new Champion(104L, "Graves", "jg", "1Tier", 97L, List.of()));
//                "Gwen": "887",
        championRepository.save(new Champion(887L, "Gwen", "top", "4Tier", 77L, List.of()));
//                "Hecarim": "120",
        championRepository.save(new Champion(120L, "Hecarim", "jg", "2Tier", 87L, List.of()));
//                "Heimerdinger": "74",
        championRepository.save(new Champion(74L, "Heimerdinger", "sup", "3Tier", 87L, List.of()));
//                "Illaoi": "420",
        championRepository.save(new Champion(420L, "Illaoi", "top", "2Tier", 84L, List.of()));
//                "Irelia": "39",
        championRepository.save(new Champion(39L, "Irelia", "top", "2Tier", 85L, List.of()));
//                "Ivern": "427",
        championRepository.save(new Champion(427L, "Ivern", "jg", "4Tier", 65L, List.of()));
//                "Janna": "40",
        championRepository.save(new Champion(40L, "Janna", "sup", "1Tier", 91L, List.of()));
//                "JarvanIV": "59",
        championRepository.save(new Champion(59L, "JarvanIV", "jg", "3Tier", 80L, List.of()));
//                "Jax": "24",
        championRepository.save(new Champion(24L, "Jax", "top", "2Tier", 87L, List.of()));
//                "Jayce": "126",
        championRepository.save(new Champion(126L, "Jayce", "top", "4Tier", 77L, List.of()));
//                "Jhin": "202",
        championRepository.save(new Champion(202L, "Jhin", "adc", "1Tier", 91L, List.of()));
//                "Jinx": "222",
        championRepository.save(new Champion(222L, "Jinx", "adc", "3Tier", 81L, List.of()));
//                "Kaisa": "145",
        championRepository.save(new Champion(145L, "Kaisa", "adc", "1Tier", 95L, List.of()));
//                "Kalista": "429",
        championRepository.save(new Champion(429L, "Kalista", "adc", "4Tier", 71L, List.of()));
//                "Karma": "43",
        championRepository.save(new Champion(43L, "Karma", "sup", "3Tier", 85L, List.of()));
//                "Karthus": "30",
        championRepository.save(new Champion(30L, "Karthus", "jg", "4Tier", 70L, List.of()));
//                "Kassadin": "38",
        championRepository.save(new Champion(38L, "Kassadin", "mid", "3Tier", 81L, List.of()));
//                "Katarina": "55",
        championRepository.save(new Champion(55L, "Katarina", "mid", "1Tier", 97L, List.of()));
//                "Kayle": "10",
        championRepository.save(new Champion(10L, "Kayle", "top", "4Tier", 68L, List.of()));
//                "Kayn": "141",
        championRepository.save(new Champion(141L, "Kayn", "jg", "2Tier", 82L, List.of()));
//                "Kennen": "85",
        championRepository.save(new Champion(85L, "Kennen", "top", "5Tier", 70L, List.of()));
//                "Khazix": "121",
        championRepository.save(new Champion(121L, "Khazix", "jg", "2Tier", 88L, List.of()));
//                "Kindred": "203",
        championRepository.save(new Champion(203L, "Kindred", "jg", "2Tier", 89L, List.of()));
//                "Kled": "240",
        championRepository.save(new Champion(240L, "Kled", "top", "2Tier", 81L, List.of()));
//                "KogMaw": "96",
        championRepository.save(new Champion(96L, "KogMaw", "adc", "4Tier", 70L, List.of()));
//                "Leblanc": "7",
        championRepository.save(new Champion(7L, "Leblanc", "mid", "4Tier", 80L, List.of()));
//                "LeeSin": "64",
        championRepository.save(new Champion(64L, "LeeSin", "jg", "3Tier", 85L, List.of()));
//                "Leona": "89",
        championRepository.save(new Champion(89L, "Leona", "sup", "3Tier", 85L, List.of()));
//                "Lillia": "876",
        championRepository.save(new Champion(876L, "Lillia", "jg", "3Tier", 77L, List.of()));
//                "Lissandra": "127",
        championRepository.save(new Champion(127L, "Lissandra", "mid", "4Tier", 79L, List.of()));
//                "Lucian": "236",
        championRepository.save(new Champion(236L, "Lucian", "adc", "3Tier", 86L, List.of()));
//                "Lulu": "117",
        championRepository.save(new Champion(117L, "Lulu", "sup", "3Tier", 86L, List.of()));
//                "Lux": "99",
        championRepository.save(new Champion(99L, "Lux", "sup", "2Tier", 89L, List.of()));
//                "Malphite": "54",
        championRepository.save(new Champion(54L, "Malphite", "top", "4Tier", 69L, List.of()));
//                "Malzahar": "90",
        championRepository.save(new Champion(90L, "Malzahar", "mid", "3Tier", 74L, List.of()));
//                "Maokai": "57",
        championRepository.save(new Champion(57L, "Maokai", "sup", "2Tier", 79L, List.of()));
//                "MasterYi": "11",
        championRepository.save(new Champion(11L, "MasterYi", "jg", "1Tier", 90L, List.of()));
//                "MissFortune": "21",
        championRepository.save(new Champion(21L, "MissFortune", "adc", "3Tier", 82L, List.of()));
//                "MonkeyKing": "62",
        championRepository.save(new Champion(62L, "MonkeyKing", "jg", "3Tier", 73L, List.of()));
//                "Mordekaiser": "82",
        championRepository.save(new Champion(82L, "Mordekaiser", "top", "1Tier", 95L, List.of()));
//                "Morgana": "25",
        championRepository.save(new Champion(25L, "Morgana", "sup", "2Tier", 89L, List.of()));
//                "Nami": "267",
        championRepository.save(new Champion(267L, "Nami", "sup", "1Tier", 97L, List.of()));
//                "Nasus": "75",
        championRepository.save(new Champion(75L, "Nasus", "top", "1Tier", 98L, List.of()));
//                "Nautilus": "111",
        championRepository.save(new Champion(111L, "Nautilus", "sup", "3Tier", 78L, List.of()));
//                "Neeko": "518",
        championRepository.save(new Champion(518L, "Neeko", "mid", "4Tier", 73L, List.of()));
//                "Nidalee": "76",
        championRepository.save(new Champion(76L, "Nidalee", "jg", "3Tier", 79L, List.of()));
//                "Nilah": "895",
        championRepository.save(new Champion(895L, "Nilah", "adc", "2Tier", 87L, List.of()));
//                "Nocturne": "56",
        championRepository.save(new Champion(56L, "Nocturne", "jg", "3Tier", 83L, List.of()));
//                "Nunu": "20",
        championRepository.save(new Champion(20L, "Nunu", "jg", "2Tier", 85L, List.of()));
//                "Olaf": "2",
        championRepository.save(new Champion(2L, "Olaf", "top", "2Tier", 92L, List.of()));
//                "Orianna": "61",
        championRepository.save(new Champion(61L, "Orianna", "mid", "4Tier", 72L, List.of()));
//                "Ornn": "516",
        championRepository.save(new Champion(516L, "Shen", "top", "1Tier", 97L, List.of()));
//                "Pantheon": "80",
        championRepository.save(new Champion(80L, "Pantheon", "top", "4Tier", 70L, List.of()));
//                "Poppy": "78",
        championRepository.save(new Champion(78L, "Poppy", "jg", "4Tier", 74L, List.of()));
//                "Pyke": "555",
        championRepository.save(new Champion(555L, "Pyke", "sup", "2Tier", 88L, List.of()));
//                "Qiyana": "246",
        championRepository.save(new Champion(246L, "Qiyana", "mid", "3Tier", 83L, List.of()));
//                "Quinn": "133",
        championRepository.save(new Champion(133L, "Quinn", "top", "4Tier", 70L, List.of()));
//                "Rakan": "497",
        championRepository.save(new Champion(497L, "Rakan", "sup", "4Tier", 70L, List.of()));
//                "Rammus": "33",
        championRepository.save(new Champion(33L, "Rammus", "jg", "1Tier", 92L, List.of()));
//                "RekSai": "421",
        championRepository.save(new Champion(421L, "RekSai", "jg", "2Tier", 82L, List.of()));
//                "Rell": "526",
        championRepository.save(new Champion(526L, "Rell", "sup", "3Tier", 80L, List.of()));
//                "Renata": "888",
        championRepository.save(new Champion(888L, "Renata", "sup", "2Tier", 88L, List.of()));
//                "Renekton": "58",
        championRepository.save(new Champion(58L, "Renekton", "top", "3Tier", 81L, List.of()));
//                "Rengar": "107",
        championRepository.save(new Champion(107L, "Rengar", "jg", "2Tier", 85L, List.of()));
//                "Riven": "92",
        championRepository.save(new Champion(92L, "Riven", "top", "2Tier", 86L, List.of()));
//                "Rumble": "68",
        championRepository.save(new Champion(68L, "Rumble", "top", "5Tier", 66L, List.of()));
//                "Ryze": "13",
        championRepository.save(new Champion(13L, "Ryze", "mid", "5Tier", 68L, List.of()));
//                "Samira": "360",
        championRepository.save(new Champion(360L, "Samira", "adc", "1Tier", 92L, List.of()));
//                "Sejuani": "113",
        championRepository.save(new Champion(113L, "Sejuani", "top", "2Tier", 90L, List.of()));
//                "Senna": "235",
        championRepository.save(new Champion(235L, "Senna", "sup", "4Tier", 70L, List.of()));
//                "Seraphine": "147",
        championRepository.save(new Champion(147L, "Seraphine", "sup", "4Tier", 70L, List.of()));
//                "Sett": "875",
        championRepository.save(new Champion(875L, "Sett", "top", "2Tier", 91L, List.of()));
//                "Shaco": "35",
        championRepository.save(new Champion(35L, "Shaco", "jg", "2Tier", 80L, List.of()));
//                "Shen": "98",
        championRepository.save(new Champion(98L, "Shen", "top", "1Tier", 99L, List.of()));
//                "Shyvana": "102",
        championRepository.save(new Champion(102L, "Shyvana", "jg", "3Tier", 77L, List.of()));
//                "Singed": "27",
        championRepository.save(new Champion(27L, "Singed", "top", "2Tier", 88L, List.of()));
//                "Sion": "14",
        championRepository.save(new Champion(14L, "Sion", "top", "2Tier", 82L, List.of()));
//                "Sivir": "15",
        championRepository.save(new Champion(15L, "Sivir", "adc", "3Tier", 86L, List.of()));
//                "Skarner": "72",
        championRepository.save(new Champion(72L, "Skarner", "jg", "3Tier", 77L, List.of()));
//                "Sona": "37",
        championRepository.save(new Champion(37L, "Sona", "sup", "2Tier", 87L, List.of()));
//                "Soraka": "16",
        championRepository.save(new Champion(16L, "Soraka", "sup", "2Tier", 89L, List.of()));
//                "Swain": "50",
        championRepository.save(new Champion(50L, "Swain", "sup", "4Tier", 76L, List.of()));
//                "Sylas": "517",
        championRepository.save(new Champion(517L, "Sylas", "mid", "1Tier", 96L, List.of()));
//                "Syndra": "134",
        championRepository.save(new Champion(134L, "Syndra", "mid", "1Tier", 98L, List.of()));
//                "TahmKench": "223",
//                "Taliyah": "163",
//                "Talon": "91",
//                "Taric": "44",
//                "Teemo": "17",
//                "Thresh": "412",
//                "Tristana": "18",
//                "Trundle": "48",
//                "Tryndamere": "23",
//                "TwistedFate": "4",
//                "Twitch": "29",
//                "Udyr": "77",
//                "Urgot": "6",
        championRepository.save(new Champion(6L, "Urgot", "top", "2Tier", 84L, List.of()));
//                "Varus": "110",
//                "Vayne": "67",
//                "Veigar": "45",
//                "Velkoz": "161",
//                "Vex": "711",
        championRepository.save(new Champion(711L, "Vex", "mid", "1Tier", 100L, List.of()));
//                "Vi": "254",
//                "Viego": "234",
//                "Viktor": "112",
//                "Vladimir": "8",
//                "Volibear": "106",
//                "Warwick": "19",
        championRepository.save(new Champion(19L, "Warwick", "top", "2Tier", 83L, List.of()));
//                "Xayah": "498",
//                "Xerath": "101",
//                "XinZhao": "5",
//                "Yasuo": "157",
//                "Yone": "777",
//                "Yorick": "83",
//                "Yuumi": "350",
//                "Zac": "154",
//                "Zed": "238",
        championRepository.save(new Champion(238L, "Zed", "mid", "1Tier", 99L, List.of()));
//                "Zeri": "221",
//                "Ziggs": "115",
//                "Zilean": "26",
//                "Zoe": "142",
//                "Zyra": "143"
    }

    public Champion findTestData(Long champId) {
        return championRepository.findByChampId(champId).orElseThrow();
    }
}
