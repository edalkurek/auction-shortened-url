package com.example.auctionshortenedurl.api;

import com.example.auctionshortenedurl.business.IUrlService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s")
public class UrlRedirectController {

  private final IUrlService iUrlService;

  public UrlRedirectController(IUrlService iUrlService) {
    this.iUrlService = iUrlService;
  }

  @GetMapping("/{urlHash}")
  public void redirectUrl(@PathVariable String urlHash, HttpServletResponse httpServletResponse) throws IOException {
    httpServletResponse.sendRedirect(iUrlService.getLongUrl(urlHash));
  }
}
