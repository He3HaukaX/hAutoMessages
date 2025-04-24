package ru.he3hauka.hautomessages.utils;

import java.util.HashMap;
import java.util.Map;

public class Localization {

    private final String locale;

    public Localization(String locale) {
        this.locale = locale.toLowerCase();
    }

    public String get(String key, Object... args) {
        String message = MESSAGES.getOrDefault(locale, MESSAGES.get("en")).getOrDefault(key, "§cMissing translation: " + key);
        for (int i = 0; i < args.length; i++) {
            message = message.replace("{" + i + "}", args[i].toString());
        }
        return message;
    }

    private static final Map<String, Map<String, String>> MESSAGES = new HashMap<>();

    static {
        Map<String, String> en = new HashMap<>();
        en.put("no_permission", "§cYou don't have the hautomessages.admin permission!");
        en.put("reloading_plugin", "Reloading plugin...");
        en.put("plugin_reloaded", "Plugin reloaded in §a{0}§f ms");
        en.put("starting_auto_messages", "Starting auto messages...");
        en.put("auto_messages_started", "Auto messages started!");
        en.put("stopping_auto_messages", "Stopping auto messages...");
        en.put("auto_messages_stopped", "Auto messages stopped!");
        en.put("current_index", "Current index == {0}");
        en.put("plugin_started", "Plugin successfully started! v{0}");
        en.put("plugin_stopped", "Plugin successfully stopped! v{0}");
        en.put("developer_contact", "If you have questions or suggestions, contact the developer: https://t.me/hplugin");
        MESSAGES.put("en", en);

        Map<String, String> ru = new HashMap<>();
        ru.put("no_permission", "§cУ вас нет права hautomessages.admin!");
        ru.put("reloading_plugin", "Перезагрузка плагина...");
        ru.put("plugin_reloaded", "Плагин перезагружен за §a{0}§f мс");
        ru.put("starting_auto_messages", "Запуск автосообщений...");
        ru.put("auto_messages_started", "Автосообщения запущены!");
        ru.put("stopping_auto_messages", "Остановка автосообщений...");
        ru.put("auto_messages_stopped", "Автосообщения остановлены!");
        ru.put("current_index", "Текущий индекс == {0}");
        ru.put("plugin_started", "Плагин успешно запущен! v{0}");
        ru.put("plugin_stopped", "Плагин успешно выключен! v{0}");
        ru.put("developer_contact", "Если у вас есть вопросы или предложения, пишите разработчику: https://t.me/hplugin");
        MESSAGES.put("ru", ru);

        Map<String, String> uk = new HashMap<>();
        uk.put("no_permission", "§cУ вас немає дозволу hautomessages.admin!");
        uk.put("reloading_plugin", "Перезавантаження плагіна...");
        uk.put("plugin_reloaded", "Плагін перезавантажено за §a{0}§f мс");
        uk.put("starting_auto_messages", "Запуск автоповідомлень...");
        uk.put("auto_messages_started", "Автоповідомлення запущено!");
        uk.put("stopping_auto_messages", "Зупинка автоповідомлень...");
        uk.put("auto_messages_stopped", "Автоповідомлення зупинено!");
        uk.put("current_index", "Поточний індекс == {0}");
        uk.put("plugin_started", "Плагін успішно запущено! v{0}");
        uk.put("plugin_stopped", "Плагін успішно вимкнено! v{0}");
        uk.put("developer_contact", "Якщо у вас є питання чи пропозиції, пишіть розробнику: https://t.me/hplugin");
        MESSAGES.put("uk", uk);

        Map<String, String> fr = new HashMap<>();
        fr.put("no_permission", "§cVous n'avez pas la permission hautomessages.admin !");
        fr.put("reloading_plugin", "Rechargement du plugin...");
        fr.put("plugin_reloaded", "Plugin rechargé en §a{0}§f ms");
        fr.put("starting_auto_messages", "Démarrage des messages automatiques...");
        fr.put("auto_messages_started", "Messages automatiques démarrés !");
        fr.put("stopping_auto_messages", "Arrêt des messages automatiques...");
        fr.put("auto_messages_stopped", "Messages automatiques arrêtés !");
        fr.put("current_index", "Index actuel == {0}");
        fr.put("plugin_started", "Plugin démarré avec succès ! v{0}");
        fr.put("plugin_stopped", "Plugin arrêté avec succès ! v{0}");
        fr.put("developer_contact", "Si vous avez des questions ou des suggestions, contactez le développeur : https://t.me/hplugin");
        MESSAGES.put("fr", fr);

        Map<String, String> de = new HashMap<>();
        de.put("no_permission", "§cSie haben nicht die Berechtigung hautomessages.admin!");
        de.put("reloading_plugin", "Plugin wird neu geladen...");
        de.put("plugin_reloaded", "Plugin neu geladen in §a{0}§f ms");
        de.put("starting_auto_messages", "Automatische Nachrichten starten...");
        de.put("auto_messages_started", "Automatische Nachrichten gestartet!");
        de.put("stopping_auto_messages", "Automatische Nachrichten stoppen...");
        de.put("auto_messages_stopped", "Automatische Nachrichten gestoppt!");
        de.put("current_index", "Aktueller Index == {0}");
        de.put("plugin_started", "Plugin erfolgreich gestartet! v{0}");
        de.put("plugin_stopped", "Plugin erfolgreich gestoppt! v{0}");
        de.put("developer_contact", "Wenn du Fragen oder Vorschläge hast, kontaktiere den Entwickler: https://t.me/hplugin");
        MESSAGES.put("de", de);

        Map<String, String> es = new HashMap<>();
        es.put("no_permission", "§c¡No tienes el permiso hautomessages.admin!");
        es.put("reloading_plugin", "Recargando el plugin...");
        es.put("plugin_reloaded", "Plugin recargado en §a{0}§f ms");
        es.put("starting_auto_messages", "Iniciando mensajes automáticos...");
        es.put("auto_messages_started", "¡Mensajes automáticos iniciados!");
        es.put("stopping_auto_messages", "Deteniendo mensajes automáticos...");
        es.put("auto_messages_stopped", "¡Mensajes automáticos detenidos!");
        es.put("current_index", "Índice actual == {0}");
        es.put("plugin_started", "¡Plugin iniciado correctamente! v{0}");
        es.put("plugin_stopped", "¡Plugin detenido correctamente! v{0}");
        es.put("developer_contact", "Si tienes preguntas o sugerencias, contacta con el desarrollador: https://t.me/hplugin");
        MESSAGES.put("es", es);

        Map<String, String> zh = new HashMap<>();
        zh.put("no_permission", "§c你没有权限 hautomessages.admin!");
        zh.put("reloading_plugin", "正在重新加载插件...");
        zh.put("plugin_reloaded", "插件已重新加载，用时 §a{0}§f 毫秒");
        zh.put("starting_auto_messages", "开始自动消息...");
        zh.put("auto_messages_started", "自动消息已启动！");
        zh.put("stopping_auto_messages", "停止自动消息...");
        zh.put("auto_messages_stopped", "自动消息已停止！");
        zh.put("current_index", "当前索引 == {0}");
        zh.put("plugin_started", "插件成功启动！v{0}");
        zh.put("plugin_stopped", "插件成功停止！v{0}");
        zh.put("developer_contact", "如果您有任何问题或建议，请联系开发者：https://t.me/hplugin");
        MESSAGES.put("zh", zh);

        Map<String, String> ar = new HashMap<>();
        ar.put("no_permission", "§cليس لديك إذن hautomessages.admin!");
        ar.put("reloading_plugin", "جارٍ إعادة تحميل الإضافة...");
        ar.put("plugin_reloaded", "تم إعادة تحميل الإضافة في §a{0}§f مللي ثانية");
        ar.put("starting_auto_messages", "بدء الرسائل التلقائية...");
        ar.put("auto_messages_started", "تم بدء الرسائل التلقائية!");
        ar.put("stopping_auto_messages", "إيقاف الرسائل التلقائية...");
        ar.put("auto_messages_stopped", "تم إيقاف الرسائل التلقائية!");
        ar.put("current_index", "الفهرس الحالي == {0}");
        ar.put("plugin_started", "تم تشغيل الإضافة بنجاح! v{0}");
        ar.put("plugin_stopped", "تم إيقاف الإضافة بنجاح! v{0}");
        ar.put("developer_contact", "إذا كانت لديك أي أسئلة أو اقتراحات، يرجى الاتصال بالمطور: https://t.me/hplugin");
        MESSAGES.put("ar", ar);

        Map<String, String> pl = new HashMap<>();
        pl.put("no_permission", "§cNie masz uprawnień do hautomessages.admin!");
        pl.put("reloading_plugin", "Przeładowywanie wtyczki...");
        pl.put("plugin_reloaded", "Wtyczka przeładowana w §a{0}§f ms");
        pl.put("starting_auto_messages", "Uruchamianie automatycznych wiadomości...");
        pl.put("auto_messages_started", "Automatyczne wiadomości uruchomione!");
        pl.put("stopping_auto_messages", "Zatrzymywanie automatycznych wiadomości...");
        pl.put("auto_messages_stopped", "Automatyczne wiadomości zatrzymane!");
        pl.put("current_index", "Aktualny indeks == {0}");
        pl.put("plugin_started", "Plugin uruchomiony pomyślnie! v{0}");
        pl.put("plugin_stopped", "Plugin zatrzymany pomyślnie! v{0}");
        pl.put("developer_contact", "Jeśli masz pytania lub sugestie, skontaktuj się z deweloperem: https://t.me/hplugin");
        MESSAGES.put("pl", pl);

        Map<String, String> pt = new HashMap<>();
        pt.put("no_permission", "§cVocê não tem permissão hautomessages.admin!");
        pt.put("reloading_plugin", "Recarregando o plugin...");
        pt.put("plugin_reloaded", "Plugin recarregado em §a{0}§f ms");
        pt.put("starting_auto_messages", "Iniciando mensagens automáticas...");
        pt.put("auto_messages_started", "Mensagens automáticas iniciadas!");
        pt.put("stopping_auto_messages", "Parando mensagens automáticas...");
        pt.put("auto_messages_stopped", "Mensagens automáticas paradas!");
        pt.put("current_index", "Índice atual == {0}");
        pt.put("plugin_started", "Plugin iniciado com sucesso! v{0}");
        pt.put("plugin_stopped", "Plugin parado com sucesso! v{0}");
        pt.put("developer_contact", "Se você tiver dúvidas ou sugestões, entre em contato com o desenvolvedor: https://t.me/hplugin");
        MESSAGES.put("pt", pt);

        Map<String, String> it = new HashMap<>();
        it.put("no_permission", "§cNon hai il permesso hautomessages.admin!");
        it.put("reloading_plugin", "Ricaricamento del plugin...");
        it.put("plugin_reloaded", "Plugin ricaricato in §a{0}§f ms");
        it.put("starting_auto_messages", "Avvio dei messaggi automatici...");
        it.put("auto_messages_started", "Messaggi automatici avviati!");
        it.put("stopping_auto_messages", "Arresto dei messaggi automatici...");
        it.put("auto_messages_stopped", "Messaggi automatici fermati!");
        it.put("current_index", "Indice corrente == {0}");
        it.put("plugin_started", "Plugin avviato correttamente! v{0}");
        it.put("plugin_stopped", "Plugin fermato correttamente! v{0}");
        it.put("developer_contact", "Se hai domande o suggerimenti, contatta lo sviluppatore: https://t.me/hplugin");
        MESSAGES.put("it", it);

        Map<String, String> be = new HashMap<>();
        be.put("no_permission", "§cУ вас няма дазволу hautomessages.admin!");
        be.put("reloading_plugin", "Перазагрузка плагіна...");
        be.put("plugin_reloaded", "Плагін перазагружаны за §a{0}§f мс");
        be.put("starting_auto_messages", "Запуск аўтаматычных паведамленняў...");
        be.put("auto_messages_started", "Аўтаматычныя паведамленні запушчаны!");
        be.put("stopping_auto_messages", "Спыненне аўтаматычных паведамленняў...");
        be.put("auto_messages_stopped", "Аўтаматычныя паведамленні спынены!");
        be.put("current_index", "Цяперашні індэкс == {0}");
        be.put("plugin_started", "Плагін паспяхова запушчаны! v{0}");
        be.put("plugin_stopped", "Плагін паспяхова спынены! v{0}");
        be.put("developer_contact", "Калі ў вас ёсць пытанні або прапановы, звяртайцеся да распрацоўніка: https://t.me/hplugin");
        MESSAGES.put("be", be);

        Map<String, String> af = new HashMap<>();
        af.put("no_permission", "§cJy het nie die hautomessages.admin toestemming nie!");
        af.put("reloading_plugin", "Herlaai van plugin...");
        af.put("plugin_reloaded", "Plugin herlaai in §a{0}§f ms");
        af.put("starting_auto_messages", "Begin outomatiese boodskappe...");
        af.put("auto_messages_started", "Outomatiese boodskappe begin!");
        af.put("stopping_auto_messages", "Stop outomatiese boodskappe...");
        af.put("auto_messages_stopped", "Outomatiese boodskappe gestop!");
        af.put("current_index", "Huidige indeks == {0}");
        af.put("plugin_started", "Plugin suksesvol begin! v{0}");
        af.put("plugin_stopped", "Plugin suksesvol gestop! v{0}");
        af.put("developer_contact", "As jy enige vrae of voorstelle het, kontak die ontwikkelaar: https://t.me/hplugin");
        MESSAGES.put("af", af);

        Map<String, String> sq = new HashMap<>();
        sq.put("no_permission", "§cNuk keni lejen hautomessages.admin!");
        sq.put("reloading_plugin", "Rikthim i plugin...");
        sq.put("plugin_reloaded", "Plugin u ngarkua ne §a{0}§f ms");
        sq.put("starting_auto_messages", "Fillimi i mesazheve automatike...");
        sq.put("auto_messages_started", "Mesazhet automatike filluan!");
        sq.put("stopping_auto_messages", "Ndalo mesazhet automatike...");
        sq.put("auto_messages_stopped", "Mesazhet automatike u ndalen!");
        sq.put("current_index", "Indeksi aktual == {0}");
        sq.put("plugin_started", "Plugin u nis me sukses! v{0}");
        sq.put("plugin_stopped", "Plugin u ndal me sukses! v{0}");
        sq.put("developer_contact", "Nëse keni pyetje ose sugjerime, kontaktoni zhvilluesin: https://t.me/hplugin");
        MESSAGES.put("sq", sq);

        Map<String, String> am = new HashMap<>();
        am.put("no_permission", "§cእርስዎ የhautomessages.admin ፈቃድ አልተከፈተም!");
        am.put("reloading_plugin", "ፕላግን እንደገና ማስገባት...");
        am.put("plugin_reloaded", "ፕላግን በ§a{0}§f ሚሴኮንድ ተመለሰ");
        am.put("starting_auto_messages", "አሰናዳደር መልእክቶች መጀመር...");
        am.put("auto_messages_started", "አሰናዳደር መልእክቶች ጀምሯል!");
        am.put("stopping_auto_messages", "አሰናዳደር መልእክቶች ማቆም...");
        am.put("auto_messages_stopped", "አሰናዳደር መልእክቶች ተዘግተዋል!");
        am.put("current_index", "አሁን ስር ቁጥር == {0}");
        am.put("plugin_started", "ፕላግን በስኬት ተጀመረ! v{0}");
        am.put("plugin_stopped", "ፕላግን በስኬት ተነቀረ! v{0}");
        am.put("developer_contact", "እንደሆነ ጥያቄዎች ወይም ምክር ከሆነ፣ ለማስተናገድ ለምንጭ ተጠቀሙ: https://t.me/hplugin");
        MESSAGES.put("am", am);

        Map<String, String> hy = new HashMap<>();
        hy.put("no_permission", "§cԴուք չունեք hautomessages.admin թույլտվությունը!");
        hy.put("reloading_plugin", "Պլագինի վերալիցքավորում...");
        hy.put("plugin_reloaded", "Պլագինը վերալիցքավորվեց §a{0}§f միլիվայրկյանում");
        hy.put("starting_auto_messages", "Ավտոմատ հաղորդագրությունների մեկնարկ...");
        hy.put("auto_messages_started", "Ավտոմատ հաղորդագրությունները մեկնարկեցին!");
        hy.put("stopping_auto_messages", "Ավտոմատ հաղորդագրությունների դադարեցում...");
        hy.put("auto_messages_stopped", "Ավտոմատ հաղորդագրությունները դադարեցվեցին!");
        hy.put("current_index", "Ընթացիկ ինդեքս == {0}");
        hy.put("plugin_started", "Պլագինը հաջողությամբ մեկնարկեց! v{0}");
        hy.put("plugin_stopped", "Պլագինը հաջողությամբ դադարեցվեց! v{0}");
        hy.put("developer_contact", "Եթե հարցեր կամ առաջարկներ ունեք, կապվեք մշակողի հետ: https://t.me/hplugin");
        MESSAGES.put("hy", hy);

        Map<String, String> bn = new HashMap<>();
        bn.put("no_permission", "§cআপনার কাছে hautomessages.admin অনুমতি নেই!");
        bn.put("reloading_plugin", "প্লাগইন রিলোড হচ্ছে...");
        bn.put("plugin_reloaded", "প্লাগইন §a{0}§f মিলিসেকেন্ডে রিলোড হয়েছে");
        bn.put("starting_auto_messages", "অটো মেসেজ শুরু হচ্ছে...");
        bn.put("auto_messages_started", "অটো মেসেজ শুরু হয়েছে!");
        bn.put("stopping_auto_messages", "অটো মেসেজ বন্ধ হচ্ছে...");
        bn.put("auto_messages_stopped", "অটো মেসেজ বন্ধ হয়েছে!");
        bn.put("current_index", "বর্তমান সূচক == {0}");
        bn.put("plugin_started", "প্লাগইন সফলভাবে চালু হয়েছে! v{0}");
        bn.put("plugin_stopped", "প্লাগইন সফলভাবে বন্ধ হয়েছে! v{0}");
        bn.put("developer_contact", "যদি আপনার কোনও প্রশ্ন বা প্রস্তাবনা থাকে, ডেভেলপারকে যোগাযোগ করুন: https://t.me/hplugin");
        MESSAGES.put("bn", bn);

        Map<String, String> bs = new HashMap<>();
        bs.put("no_permission", "§cNemate dozvolu hautomessages.admin!");
        bs.put("reloading_plugin", "Ponovno učitavanje plugina...");
        bs.put("plugin_reloaded", "Plugin je ponovno učitan za §a{0}§f ms");
        bs.put("starting_auto_messages", "Pokretanje automatskih poruka...");
        bs.put("auto_messages_started", "Automatske poruke su pokrenute!");
        bs.put("stopping_auto_messages", "Zaustavljanje automatskih poruka...");
        bs.put("auto_messages_stopped", "Automatske poruke su zaustavljene!");
        bs.put("current_index", "Trenutni indeks == {0}");
        bs.put("plugin_started", "Plugin je uspješno pokrenut! v{0}");
        bs.put("plugin_stopped", "Plugin je uspješno zaustavljen! v{0}");
        bs.put("developer_contact", "Ako imate bilo kakvih pitanja ili prijedloga, kontaktirajte developera: https://t.me/hplugin");
        MESSAGES.put("bs", bs);

        Map<String, String> ca = new HashMap<>();
        ca.put("no_permission", "§cNo tens permís per a hautomessages.admin!");
        ca.put("reloading_plugin", "Recarregant el plugin...");
        ca.put("plugin_reloaded", "Plugin recarregat en §a{0}§f ms");
        ca.put("starting_auto_messages", "Iniciant missatges automàtics...");
        ca.put("auto_messages_started", "Missatges automàtics iniciats!");
        ca.put("stopping_auto_messages", "Aturant missatges automàtics...");
        ca.put("auto_messages_stopped", "Missatges automàtics aturats!");
        ca.put("current_index", "Índex actual == {0}");
        ca.put("plugin_started", "El plugin s'ha iniciat correctament! v{0}");
        ca.put("plugin_stopped", "El plugin s'ha aturat correctament! v{0}");
        ca.put("developer_contact", "Si tens preguntes o suggeriments, contacta amb el desenvolupador: https://t.me/hplugin");
        MESSAGES.put("ca", ca);

        Map<String, String> hr = new HashMap<>();
        hr.put("no_permission", "§cNemate dopuštenje za hautomessages.admin!");
        hr.put("reloading_plugin", "Ponovno učitavanje dodatka...");
        hr.put("plugin_reloaded", "Dodatak ponovno učitan za §a{0}§f ms");
        hr.put("starting_auto_messages", "Pokretanje automatskih poruka...");
        hr.put("auto_messages_started", "Automatske poruke pokrenute!");
        hr.put("stopping_auto_messages", "Zaustavljanje automatskih poruka...");
        hr.put("auto_messages_stopped", "Automatske poruke zaustavljene!");
        hr.put("current_index", "Trenutni indeks == {0}");
        hr.put("plugin_started", "Plugin je uspješno pokrenut! v{0}");
        hr.put("plugin_stopped", "Plugin je uspješno zaustavljen! v{0}");
        hr.put("developer_contact", "Ako imate bilo kakvih pitanja ili prijedloga, kontaktirajte developera: https://t.me/hplugin");
        MESSAGES.put("hr", hr);

        Map<String, String> ro = new HashMap<>();
        ro.put("no_permission", "§cNu aveți permisiunea hautomessages.admin!");
        ro.put("reloading_plugin", "Se reîncarcă pluginul...");
        ro.put("plugin_reloaded", "Plugin reîncărcat în §a{0}§f ms");
        ro.put("starting_auto_messages", "Pornirea mesajelor automate...");
        ro.put("auto_messages_started", "Mesaje automate pornite!");
        ro.put("stopping_auto_messages", "Oprirea mesajelor automate...");
        ro.put("auto_messages_stopped", "Mesaje automate oprite!");
        ro.put("current_index", "Indexul curent == {0}");
        ro.put("plugin_started", "Plugin-ul a fost pornit cu succes! v{0}");
        ro.put("plugin_stopped", "Plugin-ul a fost oprit cu succes! v{0}");
        ro.put("developer_contact", "Dacă aveți întrebări sau sugestii, contactați dezvoltatorul: https://t.me/hplugin");
        MESSAGES.put("ro", ro);

        Map<String, String> la = new HashMap<>();
        la.put("no_permission", "§cNon habes permissionem hautomessages.admin!");
        la.put("reloading_plugin", "Plugin recondito...");
        la.put("plugin_reloaded", "Plugin recondito in §a{0}§f ms");
        la.put("starting_auto_messages", "Satus nuntiorum automaticorum...");
        la.put("auto_messages_started", "Nuntii automatici incipientes!");
        la.put("stopping_auto_messages", "Sospensio nuntiorum automaticorum...");
        la.put("auto_messages_stopped", "Nuntii automatici cessaverunt!");
        la.put("current_index", "Index currentis == {0}");
        la.put("plugin_started", "Plugin bene initiatus est! v{0}");
        la.put("plugin_stopped", "Plugin bene desinit! v{0}");
        la.put("developer_contact", "Si quaestiones aut suggestiones habes, contacta developorem: https://t.me/hplugin");
        MESSAGES.put("la", la);
    }
}
