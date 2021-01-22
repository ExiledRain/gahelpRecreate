package io.khasang.gahelp.util;

import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.SpellServiceSoap;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class CheckText {
    private final static String ADRESS = "http://speller.yandex.net/services/spellservice?WSDL";

    public String checkText(String text) {
        URL url = null;
        try {
            url = new URL(ADRESS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        QName qname = new QName("http://speller.yandex.net/services/spellservice", "SpellService");
        Service service = Service.create(url, qname);
        SpellServiceSoap spellService = service.getPort(SpellServiceSoap.class);

        CheckTextRequest request = new CheckTextRequest();
        request.setText(text);
        request.setLang("en");
        request.setFormat("plain");

        if(spellService.checkText(request).getSpellResult().getError().size() != 0){
            return spellService.checkText(request).getSpellResult().getError().get(0).getS().toString();
        } else {
            return "Word is correct!";
        }
    }
}
