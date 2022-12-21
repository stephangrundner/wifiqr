package io.grundner.wifiqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrController {
    
    @Autowired
	private QrService qrService;

    @GetMapping(path = "/")
    public String generate(
        @RequestParam(name = "ssid") String ssid,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "hidden", required = false, defaultValue = "false") boolean hidden) {

        String url = qrService.generateUrl(ssid, password, hidden);

        return url;
    }
}
