/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.color.ColorUtility;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author josmario
 */
public class HtmlUtility {

    private static HtmlUtility instance;

    private HtmlUtility() {
    }

    public static HtmlUtility getInstance() {
        if (instance == null) {
            instance = new HtmlUtility();
        }
        return instance;
    }

    /**
     * Gets html content from a given page
     *
     * @param url Page URL
     * @return
     */
    public String getPage(String url) {
        Document page = null;
        try {
            page = Jsoup.parseBodyFragment(
                    Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36")
                            .timeout(10000)
                            .get()
                            .body()
                            .html()
            );
//            page = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return page.toString();
    }

    public Document getPageDocument(String url) {
        Document page = null;
        try {
            page = Jsoup.parseBodyFragment(
                    Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36")
                            .timeout(10000)
                            .get()
                            .body()
                            .html()
            );

//            page = Jsoup.parse(new URL(url), 1000);
            //page = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }

    public List<String> getWordList(String url) {
        List<String> result = new ArrayList<>();

        String pageContent;

        if (url.equals("https://www.balletstuff.com.au/")) {
            pageContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<title>Children's DanceWear: Girls Ballet Shoes, Tights, Leotards, Tutus Home page</title>\n" +
"<meta name=\"description\" content=\"Children's dancewear specialist for girls ballet shoes, tights, leotards, tutus and much more.\" />\n" +
"<meta name=\"keywords\" content=\"Children's Ballet Shoes,Dance Tights,Dance Leotards,Ballet Tutus\" />\n" +
"<meta name=\"robots\" content=\"INDEX,FOLLOW\" />\n" +
"<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1, maximum-scale=1\" />\n" +
"<link rel=\"icon\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/favicon.ico\" type=\"image/x-icon\" />\n" +
"<link rel=\"shortcut icon\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/favicon.ico\" type=\"image/x-icon\" />\n" +
"\n" +
"<link media=\"all\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/styles.css3.php?url=https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/\" type=\"text/css\" rel=\"stylesheet\" />\n" +
"\n" +
"<!--[if lt IE 7]>\n" +
"<script type=\"text/javascript\">\n" +
"//<![CDATA[\n" +
"    var BLANK_URL = 'https://www.balletstuff.com.au/js/blank.html';\n" +
"    var BLANK_IMG = 'https://www.balletstuff.com.au/js/spacer.gif';\n" +
"//]]>\n" +
"</script>\n" +
"<![endif]-->\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/bootstrap.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/bootstrap-responsive.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/base/default/css/widgets.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/itheaven/itheavenautorelated/autorelated.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/fancybox/jquery.fancybox.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/ajaxcartsuper/ajax_cart_super.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/ma.brandslider.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/custommenu.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/layerednavigationajax/jquery-ui.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/ma.onsaleslider.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/ma.relatedslider.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/colortool/css/ma.cltool.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/colortool/css/colorpicker.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/ma.banner7.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/ma.featuredslider.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/css/ma.newslider.css\" media=\"all\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/print.css\" media=\"print\" />\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/prototype/prototype.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/lib/ccard.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/prototype/validation.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/scriptaculous/builder.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/scriptaculous/effects.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/scriptaculous/dragdrop.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/scriptaculous/controls.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/scriptaculous/slider.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/varien/js.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/varien/form.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/varien/menu.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/mage/translate.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/mage/cookies.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ma.jq.slide.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ma.flexslider.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/jquery-ui.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/bootstrap/bootstrap.min.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/bootstrap/bootstrap-tooltip.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ma.mobilemenu.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ma.menu.effect.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/backtotop.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ma.lettering.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ajax_cart_super.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/fancybox/jquery.fancybox.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/custommenu/custommenu.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/colortool/colorpicker.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/colortool/jquery.cookie.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/magentothem/ma.nivo.js\"></script>\n" +
"<!--[if lt IE 9]>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/styles-ie8.css\" media=\"all\" />\n" +
"<![endif]-->\n" +
"<!--[if lt IE 8]>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/styles-ie.css\" media=\"all\" />\n" +
"<![endif]-->\n" +
"<!--[if lt IE 7]>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/js/lib/ds-sleight.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"https://www.balletstuff.com.au/skin/frontend/base/default/js/ie6.js\"></script>\n" +
"<![endif]-->\n" +
"\n" +
"<script type=\"text/javascript\">\n" +
"//<![CDATA[\n" +
"Mage.Cookies.path     = '/';\n" +
"Mage.Cookies.domain   = '.balletstuff.com.au';\n" +
"//]]>\n" +
"</script>\n" +
"\n" +
"<script type=\"text/javascript\">\n" +
"//<![CDATA[\n" +
"optionalZipCountries = [\"HK\",\"IE\",\"MO\",\"PA\"];\n" +
"//]]>\n" +
"</script>\n" +
"            <!-- BEGIN GOOGLE ANALYTICS CODE -->\n" +
"        <script type=\"text/javascript\">\n" +
"        //<![CDATA[\n" +
"            var _gaq = _gaq || [];\n" +
"            \n" +
"_gaq.push(['_setAccount', 'UA-8040462-1']);\n" +
"\n" +
"_gaq.push(['_trackPageview']);\n" +
"            \n" +
"            (function() {\n" +
"                var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n" +
"                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n" +
"                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n" +
"            })();\n" +
"\n" +
"        //]]>\n" +
"        </script>\n" +
"        <!-- END GOOGLE ANALYTICS CODE -->\n" +
"    <script type=\"text/javascript\">//<![CDATA[\n" +
"        var Translator = new Translate([]);\n" +
"        //]]></script>\n" +
"<!-- set css color -->\n" +
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/css/styles_pink.css\" media=\"screen\" />\n" +
"</head>\n" +
"<body class=\" cms-index-index cms-home\">\n" +
"<div class=\"ma-wrapper\">\n" +
"        <noscript>\n" +
"        <div class=\"global-site-notice noscript\">\n" +
"            <div class=\"notice-inner\">\n" +
"                <p>\n" +
"                    <strong>JavaScript seems to be disabled in your browser.</strong><br />\n" +
"                    You must have JavaScript enabled in your browser to utilize the functionality of this website.                </p>\n" +
"            </div>\n" +
"        </div>\n" +
"    </noscript>\n" +
"    <div class=\"ma-page\">\n" +
"        <div class=\"ma-header-container\">\n" +
"    <div class=\"toplink\">\n" +
"        <div class=\"container\">\n" +
"                    <div class=\"row-fluid\">\n" +
"                        <div class=\"span6\">\n" +
"                            <div class=\"language_curency\">\n" +
"                                                                                            </div>\n" +
"                        </div>\n" +
"                        <div class=\"span6\">\n" +
"                            <ul class=\"links\">\n" +
"                  <li class=\"first\" ><a href=\"https://www.balletstuff.com.au/index.php/customer/account/\" title=\"My Account\" >My Account</a></li>\n" +
"                           <!--<li ><a href=\"https://www.balletstuff.com.au/index.php/wishlist/\" title=\"My Wishlist\" >My Wishlist</a></li>-->\n" +
"                           <li ><a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/\" title=\"My Cart\" class=\"top-link-cart\">My Cart</a></li>\n" +
"                           <li ><a href=\"https://www.balletstuff.com.au/index.php/checkout/\" title=\"Checkout\" class=\"top-link-checkout\">Checkout</a></li>\n" +
"                           <li ><a href=\"https://www.balletstuff.com.au/index.php/blog/\" title=\"Blog\" class=\"top-link-blog\">Blog</a></li>\n" +
"                           <li class=\" last\" ><a href=\"https://www.balletstuff.com.au/index.php/customer/account/login/\" title=\"Log In\" >Log In</a></li>\n" +
"            </ul>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"    </div>\n" +
"<div class=\"container\">\n" +
"    <div class=\"header\">\n" +
"        <div class=\"header-bottom\">\n" +
"            <div class=\"container\">\n" +
"                <div class=\"header-content\">\n" +
"                    <div class=\"row-fluid\">\n" +
"                        <div class=\"span4 logo-section\">\n" +
"                                                        <h1 class=\"logo\"><strong></strong><a href=\"https://www.balletstuff.com.au/index.php/\" title=\"\" class=\"logo\"><img src=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/images/logo.png\" alt=\"\" /></a></h1>\n" +
"                                                    </div>\n" +
"                        <div class=\"span4 searchbar-section\">\n" +
"                             <form id=\"search_mini_form\" action=\"https://www.balletstuff.com.au/index.php/catalogsearch/result/\" method=\"get\">\n" +
"    <div class=\"form-search\">\n" +
"        <label for=\"search\">Search:</label>\n" +
"        <input id=\"search\" type=\"text\" name=\"q\" value=\"\" class=\"input-text\" maxlength=\"128\" />\n" +
"        <button type=\"submit\" title=\"Search\" class=\"button\"><span><span>Search</span></span></button>\n" +
"        <div id=\"search_autocomplete\" class=\"search-autocomplete\"></div>\n" +
"        <script type=\"text/javascript\">\n" +
"        //<![CDATA[\n" +
"            var searchForm = new Varien.searchForm('search_mini_form', 'search', 'Search entire store here...');\n" +
"            searchForm.initAutocomplete('https://www.balletstuff.com.au/index.php/catalogsearch/ajax/suggest/', 'search_autocomplete');\n" +
"        //]]>\n" +
"        </script>\n" +
"    </div>\n" +
"</form>\n" +
"                        </div>\n" +
"                        <div class=\"span4 cart-section\">\n" +
"                            <div class=\"quick-access\">\n" +
"                            <div class=\"top-cart-wrapper\">\n" +
"                                <div class=\"top-cart-contain\">\n" +
"                                                                            \n" +
"                                    <script type=\"text/javascript\">\n" +
"    $jq(document).ready(function(){\n" +
"         var enable_module = $jq('#enable_module').val();\n" +
"         if(enable_module==0) return false;\n" +
"    })\n" +
"\n" +
"</script>\n" +
"<div id =\"mini_cart_block\">\n" +
"    <div class=\"block-cart mini_cart_ajax\">\n" +
"            <div class=\"block-cart\">\n" +
"                          <!--<span class=\"top-cart-icon\"></span>-->\n" +
"                <div class=\"top-cart-title\">\n" +
"                    <!--<span>Shopping Cart</span><br/>-->\n" +
"                    <span>Shopping Cart</span>\n" +
"                    <div class=\"header-item\"> item - <span class=\"price\">$0.00</span></div>\n" +
"                    <div class=\"cart_arrow\"></div>\n" +
"                </div>\n" +
"                <div class=\"top-cart-content\">\n" +
"                                                                <p class=\"empty\">You have no items in your shopping cart.</p>\n" +
"                                        <div class=\"top-subtotal\">Subtotal: <span class=\"price\">$0.00</span></div>\n" +
"                                    </div>\n" +
"            </div>\n" +
"\n" +
"    </div>\n" +
"</div>\n" +
"   \n" +
"                                </div>\n" +
"                            </div>\n" +
"                            </div>\n" +
"                            \n" +
"                        </div>\n" +
"                    </div>\n" +
"                                    </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>\n" +
"</div>\n" +
"<div class=\"ma-nav-mobile-container hidden-desktop\">\n" +
"    <div class=\"navbar\">\n" +
"        <div id=\"navbar-inner\" class=\"navbar-inner navbar-inactive\">\n" +
"            <a class=\"btn btn-navbar\">\n" +
"                <span class=\"icon-bar\"></span>\n" +
"                <span class=\"icon-bar\"></span>\n" +
"                <span class=\"icon-bar\"></span>\n" +
"            </a>\n" +
"            <span class=\"brand\">Main Menu</span>\n" +
"            <ul id=\"ma-mobilemenu\" class=\"mobilemenu nav-collapse collapse\">\n" +
"                <li class=\"level0 nav-1 level-top first\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-pack.html\" class=\"level-top\">\n" +
"<span>DANCE PACKS</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-2 level-top\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-shoes.html\" class=\"level-top\">\n" +
"<span>DANCE SHOES</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-3 level-top\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/leotards.html\" class=\"level-top\">\n" +
"<span>LEOTARDS</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-4 level-top\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gym-jazz.html\" class=\"level-top\">\n" +
"<span>GYM &amp; JAZZ</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-5 level-top\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tights-unders-136.html\" class=\"level-top\">\n" +
"<span>TIGHTS/UNDERS</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-6 level-top\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/skirts-pants-114.html\" class=\"level-top\">\n" +
"<span>SKIRTS/PANTS</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-7 level-top parent\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114.html\" class=\"level-top\">\n" +
"<span>TUTUS/DRESSES</span>\n" +
"</a>\n" +
"<ul class=\"level0\">\n" +
"<li class=\"level1 nav-7-1 first\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/dance-tutu.html\">\n" +
"<span>Dance Tutu</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-7-2\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/performance-tutus.html\">\n" +
"<span>Performance Tutus</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-7-3\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/dresses.html\">\n" +
"<span>Dresses</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-7-4\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/dress-ups.html\">\n" +
"<span>Dress Ups</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-7-5 last\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/costumes.html\">\n" +
"<span>Costumes</span>\n" +
"</a>\n" +
"</li>\n" +
"</ul>\n" +
"</li><li class=\"level0 nav-8 level-top parent\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gifts.html\" class=\"level-top\">\n" +
"<span>GIFTS</span>\n" +
"</a>\n" +
"<ul class=\"level0\">\n" +
"<li class=\"level1 nav-8-1 first\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gifts/books.html\">\n" +
"<span>Books</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-8-2\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gifts/gifts.html\">\n" +
"<span>Gifts</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-8-3 last\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gifts/craft.html\">\n" +
"<span>Craft</span>\n" +
"</a>\n" +
"</li>\n" +
"</ul>\n" +
"</li><li class=\"level0 nav-9 level-top parent\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories.html\" class=\"level-top\">\n" +
"<span>ACCESSORIES</span>\n" +
"</a>\n" +
"<ul class=\"level0\">\n" +
"<li class=\"level1 nav-9-1 first\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories/bags.html\">\n" +
"<span>Bags</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-9-2\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories/hair.html\">\n" +
"<span>Hair</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-9-3\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories/makeup.html\">\n" +
"<span>Makeup</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-9-4\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories/other.html\">\n" +
"<span>Other</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-9-5 last\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories/dvd-s-121.html\">\n" +
"<span>DVD's</span>\n" +
"</a>\n" +
"</li>\n" +
"</ul>\n" +
"</li><li class=\"level0 nav-10 level-top\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/sale.html\" class=\"level-top\">\n" +
"<span>SALE</span>\n" +
"</a>\n" +
"</li><li class=\"level0 nav-11 level-top last parent\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school.html\" class=\"level-top\">\n" +
"<span>DANCE SCHOOLS</span>\n" +
"</a>\n" +
"<ul class=\"level0\">\n" +
"<li class=\"level1 nav-11-1 first\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/bulk-discount.html\">\n" +
"<span>Bulk Discounts</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-2\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/allegro-ballet-school.html\">\n" +
"<span>Allegro Ballet School</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-3\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/bella-body-and-soul.html\">\n" +
"<span>Bella Body and Soul</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-4\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/burns-bay-dance-studios.html\">\n" +
"<span>Burns Bay Dance Studios</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-5\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/central-coast-baby-ballet.html\">\n" +
"<span>Central Coast Baby Ballet</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-6\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/creswick-dance-fitness.html\">\n" +
"<span>Creswick Dance &amp; Fitness</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-7\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/dance-for-joy.html\">\n" +
"<span>Dance for Joy</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-8\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/dust-creative-arts-pilbarra.html\">\n" +
"<span>Dust Creative Arts Pilbara</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-9\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/ecole-ballet-dance-theatre.html\">\n" +
"<span>Ecole Ballet &amp; Dance Theatre</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-10\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/freedom-dance-force.html\">\n" +
"<span>Freedom Dance Force</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-11\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/glide-to-the-side-dance-studio.html\">\n" +
"<span>Glide to the Side Dance Studio</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-12\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/greenwich-dance.html\">\n" +
"<span>Greenwich Dance</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-13\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/horsham-school-of-dance.html\">\n" +
"<span>Horsham School Of Dance</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-14\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/inspire-dance.html\">\n" +
"<span>Inspire Dance</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-15\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/kookies-n-kream.html\">\n" +
"<span>Kookies N Kream</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-16\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/liz-gregory-irish-dance-academy.html\">\n" +
"<span>Liz Gregory Irish Dance Academy</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-17\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/natalia-johnson-dance-academy.html\">\n" +
"<span>Natalia Johnson Dance Academy</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-18\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/pointe-petite.html\">\n" +
"<span>Pointe Petite</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-19\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/rpa-studios.html\">\n" +
"<span>RPA Studios</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-20\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/so-dance-junee.html\">\n" +
"<span>So Dance Junee</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-21\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/springpointe.html\">\n" +
"<span>Spring Pointe </span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-22\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/total-ballet.html\">\n" +
"<span>Total Ballet</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-23\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/twinkling-star-dance-studio.html\">\n" +
"<span>Twinkling Star Dance Studio</span>\n" +
"</a>\n" +
"</li><li class=\"level1 nav-11-24 last\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school/vibe-dance-studios.html\">\n" +
"<span>Vibe Dance Studios</span>\n" +
"</a>\n" +
"</li>\n" +
"</ul>\n" +
"</li>            </ul>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>\n" +
"<div class=\"nav-container visible-desktop\">\n" +
"    <div class=\"header-menu\">\n" +
"    <div class=\"container\">\n" +
"        <div id=\"pt_custommenu\" class=\"pt_custommenu\">\n" +
"        <div id=\"pt_menu_home\" class=\"pt_menu\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/\">\n" +
"<span>Home</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>            <div id=\"pt_menu216\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-pack.html\">\n" +
"<span>DANCE&nbsp;PACKS</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu180\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-shoes.html\">\n" +
"<span>DANCE&nbsp;SHOES</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu197\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/leotards.html\">\n" +
"<span>LEOTARDS</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu193\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gym-jazz.html\">\n" +
"<span>GYM&nbsp;&amp;&nbsp;JAZZ</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu215\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tights-unders-136.html\">\n" +
"<span>TIGHTS/UNDERS</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu217\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/skirts-pants-114.html\">\n" +
"<span>SKIRTS/PANTS</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu218\" class=\"pt_menu\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114.html\">\n" +
"<span>TUTUS/DRESSES</span>\n" +
"</a>\n" +
"</div>\n" +
"<div id=\"popup218\" class=\"popup\" style=\"display: none; width: 1228px;\">\n" +
"<div class=\"block1\" id=\"block1218\">\n" +
"<div class=\"column last col1\"><div class=\"itemMenu level1\"><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/dance-tutu.html\"><span>Dance&nbsp;Tutu</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/performance-tutus.html\"><span>Performance&nbsp;Tutus</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/dresses.html\"><span>Dresses</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/dress-ups.html\"><span>Dress&nbsp;Ups</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/tutus-dresses-114/costumes.html\"><span>Costumes</span></a></div></div>\n" +
"<div class=\"clearBoth\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu198\" class=\"pt_menu\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/gifts.html\">\n" +
"<span>GIFTS</span>\n" +
"</a>\n" +
"</div>\n" +
"<div id=\"popup198\" class=\"popup\" style=\"display: none; width: 1228px;\">\n" +
"<div class=\"block1\" id=\"block1198\">\n" +
"<div class=\"column last col1\"><div class=\"itemMenu level1\"><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/gifts/books.html\"><span>Books</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/gifts/gifts.html\"><span>Gifts</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/gifts/craft.html\"><span>Craft</span></a></div></div>\n" +
"<div class=\"clearBoth\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu185\" class=\"pt_menu\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/accessories.html\">\n" +
"<span>ACCESSORIES</span>\n" +
"</a>\n" +
"</div>\n" +
"<div id=\"popup185\" class=\"popup\" style=\"display: none; width: 1228px;\">\n" +
"<div class=\"block1\" id=\"block1185\">\n" +
"<div class=\"column last col1\"><div class=\"itemMenu level1\"><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/accessories/bags.html\"><span>Bags</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/accessories/hair.html\"><span>Hair</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/accessories/makeup.html\"><span>Makeup</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/accessories/other.html\"><span>Other</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/accessories/dvd-s-121.html\"><span>DVD's</span></a></div></div>\n" +
"<div class=\"clearBoth\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu199\" class=\"pt_menu pt_menu_no_child\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/sale.html\">\n" +
"<span>SALE</span>\n" +
"</a>\n" +
"</div>\n" +
"</div>                    <div id=\"pt_menu200\" class=\"pt_menu\">\n" +
"<div class=\"parentMenu\">\n" +
"<a href=\"https://www.balletstuff.com.au/index.php/dance-school.html\">\n" +
"<span>DANCE&nbsp;SCHOOLS</span>\n" +
"</a>\n" +
"</div>\n" +
"<div id=\"popup200\" class=\"popup\" style=\"display: none; width: 1228px;\">\n" +
"<div class=\"block1\" id=\"block1200\">\n" +
"<div class=\"column last col1\"><div class=\"itemMenu level1\"><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/bulk-discount.html\"><span>Bulk&nbsp;Discounts</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/allegro-ballet-school.html\"><span>Allegro&nbsp;Ballet&nbsp;School</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/bella-body-and-soul.html\"><span>Bella&nbsp;Body&nbsp;and&nbsp;Soul</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/burns-bay-dance-studios.html\"><span>Burns&nbsp;Bay&nbsp;Dance&nbsp;Studios</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/central-coast-baby-ballet.html\"><span>Central&nbsp;Coast&nbsp;Baby&nbsp;Ballet</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/creswick-dance-fitness.html\"><span>Creswick&nbsp;Dance&nbsp;&amp;&nbsp;Fitness</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/dance-for-joy.html\"><span>Dance&nbsp;for&nbsp;Joy</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/dust-creative-arts-pilbarra.html\"><span>Dust&nbsp;Creative&nbsp;Arts&nbsp;Pilbara</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/ecole-ballet-dance-theatre.html\"><span>Ecole&nbsp;Ballet&nbsp;&amp;&nbsp;Dance&nbsp;Theatre</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/freedom-dance-force.html\"><span>Freedom&nbsp;Dance&nbsp;Force</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/glide-to-the-side-dance-studio.html\"><span>Glide&nbsp;to&nbsp;the&nbsp;Side&nbsp;Dance&nbsp;Studio</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/greenwich-dance.html\"><span>Greenwich&nbsp;Dance</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/horsham-school-of-dance.html\"><span>Horsham&nbsp;School&nbsp;Of&nbsp;Dance</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/inspire-dance.html\"><span>Inspire&nbsp;Dance</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/kookies-n-kream.html\"><span>Kookies&nbsp;N&nbsp;Kream</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/liz-gregory-irish-dance-academy.html\"><span>Liz&nbsp;Gregory&nbsp;Irish&nbsp;Dance&nbsp;Academy</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/natalia-johnson-dance-academy.html\"><span>Natalia&nbsp;Johnson&nbsp;Dance&nbsp;Academy</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/pointe-petite.html\"><span>Pointe&nbsp;Petite</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/rpa-studios.html\"><span>RPA&nbsp;Studios</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/so-dance-junee.html\"><span>So&nbsp;Dance&nbsp;Junee</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/springpointe.html\"><span>Spring&nbsp;Pointe&nbsp;</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/total-ballet.html\"><span>Total&nbsp;Ballet</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/twinkling-star-dance-studio.html\"><span>Twinkling&nbsp;Star&nbsp;Dance&nbsp;Studio</span></a><a class=\"itemMenuName level1 nochild\" href=\"https://www.balletstuff.com.au/index.php/dance-school/vibe-dance-studios.html\"><span>Vibe&nbsp;Dance&nbsp;Studios</span></a></div></div>\n" +
"<div class=\"clearBoth\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>                \n" +
"                \n" +
"        <div class=\"clearBoth\"></div>\n" +
"    </div>\n" +
"    </div>\n" +
"</div>\n" +
"    </div>\n" +
"<script type=\"text/javascript\">\n" +
"//<![CDATA[\n" +
"var CUSTOMMENU_POPUP_EFFECT = 0;\n" +
"var CUSTOMMENU_POPUP_TOP_OFFSET = 55;\n" +
"//]]>\n" +
"</script>\n" +
"\n" +
"         \n" +
"	  <!-- start enable -->\n" +
"		<div class=\"ma-banner7-container\">\n" +
"		<div class=\"bg-banner7\"></div>\n" +
"        <!--<div class=\"container\">-->\n" +
"	        <div class=\"flexslider ma-nivoslider\">\n" +
"        <div class=\"ma-loading\"></div>\n" +
"		<div id=\"ma-inivoslider\" class=\"slides\">\n" +
"		\n" +
"																		\n" +
"                            <img style=\"display: none;\" src=\"https://www.balletstuff.com.au/media/magentothem/banner7/PACKS_ON_SALE.jpg\" alt=\"\" title=\"#banner7-caption1\"  />\n" +
"																			\n" +
"                            <img style=\"display: none;\" src=\"https://www.balletstuff.com.au/media/magentothem/banner7/banner-3.jpg\" alt=\"\" title=\"#banner7-caption2\"  />\n" +
"											</div>\n" +
"				\n" +
"							<div id=\"banner7-caption1\" class=\"banner7-caption nivo-html-caption nivo-caption\">\n" +
"								<div class=\"banner7-title\">\n" +
"									<h3></h3>\n" +
"								</div>\n" +
"								<div class=\"banner7-des\">\n" +
"																	</div>\n" +
"																	<div class=\"banner7-readmore\">\n" +
"										<a href=\"https://www.balletstuff.com.au/index.php/dance-pack.html\" title=\"Read more\">Read more</a>	\n" +
"									</div>\n" +
"															</div>						\n" +
"				\n" +
"							<div id=\"banner7-caption2\" class=\"banner7-caption nivo-html-caption nivo-caption\">\n" +
"								<div class=\"banner7-title\">\n" +
"									<h3></h3>\n" +
"								</div>\n" +
"								<div class=\"banner7-des\">\n" +
"																	</div>\n" +
"															</div>						\n" +
"						<script type=\"text/javascript\">\n" +
"            $jq(window).load(function() {\n" +
"                $jq('#ma-inivoslider').nivoSlider({\n" +
"                    effect: 'random',\n" +
"                    slices: 15,\n" +
"                    boxCols: 8,\n" +
"                    boxRows: 4,\n" +
"                    animSpeed: 600,\n" +
"                    pauseTime: 5000,\n" +
"                    startSlide: 0,\n" +
"										controlNav: false,\n" +
"										                    controlNavThumbs: false,\n" +
"                    pauseOnHover: true,\n" +
"                    manualAdvance: false,\n" +
"                    prevText: 'Prev',\n" +
"                    nextText: 'Next',\n" +
"                    afterLoad: function(){\n" +
"                        $jq('.ma-loading').css(\"display\",\"none\");\n" +
"                        //$jq('.banner7-title, .banner7-des, .banner7-readmore').css(\"left\",\"100px\") ;\n" +
"                        },     \n" +
"                    beforeChange: function(){ \n" +
"                        $jq('.banner7-title, .banner7-des').css(\"left\",\"-550px\" );\n" +
"                        $jq('.banner7-readmore').css(\"left\",\"-1500px\"); \n" +
"                    }, \n" +
"                    afterChange: function(){ \n" +
"                        $jq('.banner7-title, .banner7-des, .banner7-readmore').css(\"left\",\"40px\") \n" +
"                    }\n" +
"                });\n" +
"            });\n" +
"		</script>\n" +
"	</div>\n" +
"        <!--</div>-->\n" +
"	</div>\n" +
" <!-- end enable -->        <div class=\"banner-static-top\">\n" +
"<div class=\"container\">\n" +
"<div class=\"row-fluid\">\n" +
"<div class=\"span4\">\n" +
"<div class=\"banner-top\"><a href=\"https://www.balletstuff.com.au/index.php/dance-shoes.html\"><img src=\"https://www.balletstuff.com.au/media/wysiwyg/Small_banner_size_370_by_184_-_Ballet_Shoes.png\" alt=\"\" /></a></div>\n" +
"</div>\n" +
"<div class=\"span4\">\n" +
"<div class=\"banner-top\"><a href=\"https://www.balletstuff.com.au/index.php/dance-pack.html\"><img src=\"https://www.balletstuff.com.au/media/wysiwyg/Small_banner_size_370_by_184_-_Packs.png\" alt=\"\" /></a></div>\n" +
"</div>\n" +
"<div class=\"span4\">\n" +
"<div class=\"banner-top\"><a href=\"https://www.balletstuff.com.au/index.php/tights-unders-23.html\"><img src=\"https://www.balletstuff.com.au/media/wysiwyg/Small_banner_size_370_by_184_-_Tights.png\" alt=\"\" /></a></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</div>        <div class=\"ma-main-container col2-left-layout\">\n" +
"            <div class=\"container\">\n" +
"                <div class=\"main\">\n" +
"                    <div class=\"main-inner\">\n" +
"                                                <div class=\"row-fluid show-grid\">\n" +
"                            <div class=\"col-left sidebar span3\">\n" +
"                            <div class=\"ma-onsaleproductslider-container\">\n" +
"				<div class=\"ma-onsaleproductslider-title\"><h2>Sale Products</h2></div>\n" +
"				<div class=\"flexslider carousel\">\n" +
"			<ul class=\"slides\">\n" +
"													<li class=\"onsaleproductslider-item\">\n" +
"					<a href=\"https://www.balletstuff.com.au/index.php/ccbb-leather-ballet-shoes-pink-full-sole-5113.html\" title=\"CCBB Leather Ballet Shoes (Pink)  - Full Sole\" class=\"product-image\"><img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff-ballet-shoes1.jpg\" width=\"135\" height=\"135\" alt=\"CCBB Leather Ballet Shoes (Pink)  - Full Sole\" /></a>\n" +
"					<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/ccbb-leather-ballet-shoes-pink-full-sole-5113.html\" title=\"CCBB Leather Ballet Shoes (Pink)  - Full Sole\">CCBB Leather Ballet Shoes (Pink)  - Full Sole</a></h2>\n" +
"															<div class=\"actions\">\n" +
"																		<a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/add/uenc/aHR0cHM6Ly93d3cuYmFsbGV0c3R1ZmYuY29tLmF1Lw,,/product/5053/form_key/Qz98ZfFiF9N32dGf/\">\n" +
"								<button type=\"button\" class=\"button btn-cart msa\"><span><span>Add to Cart</span></span></button>\n" +
"							</a>\n" +
"																					</div>\n" +
"				</li>                    \n" +
"							<li class=\"onsaleproductslider-item\">\n" +
"					<a href=\"https://www.balletstuff.com.au/index.php/mary-jane-tap-shoes-tan.html\" title=\"Mary Jane Tap Shoes (Tan)\" class=\"product-image\"><img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/a/tap-shoes-tan.jpg\" width=\"135\" height=\"135\" alt=\"Mary Jane Tap Shoes (Tan)\" /></a>\n" +
"					<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/mary-jane-tap-shoes-tan.html\" title=\"Mary Jane Tap Shoes (Tan)\">Mary Jane Tap Shoes (Tan)</a></h2>\n" +
"															<div class=\"actions\">\n" +
"																		<a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/add/uenc/aHR0cHM6Ly93d3cuYmFsbGV0c3R1ZmYuY29tLmF1Lw,,/product/2141/form_key/Qz98ZfFiF9N32dGf/\">\n" +
"								<button type=\"button\" class=\"button btn-cart msa\"><span><span>Add to Cart</span></span></button>\n" +
"							</a>\n" +
"																					</div>\n" +
"				</li>                    \n" +
"							<li class=\"onsaleproductslider-item\">\n" +
"					<a href=\"https://www.balletstuff.com.au/index.php/cdf-ballet-pack-shoes-tank-leotard-theatrical-tights-skirt.html\" title=\"CDF Ballet Pack: Shoes, Tank Leotard, Theatrical Tights &amp; Skirt\" class=\"product-image\"><img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff-best-seller-ballet-pack1.jpg\" width=\"135\" height=\"135\" alt=\"CDF Ballet Pack: Shoes, Tank Leotard, Theatrical Tights &amp; Skirt\" /></a>\n" +
"					<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/cdf-ballet-pack-shoes-tank-leotard-theatrical-tights-skirt.html\" title=\"CDF Ballet Pack: Shoes, Tank Leotard, Theatrical Tights &amp; Skirt\">CDF Ballet Pack: Shoes, Tank Leotard, Theatrical Tights &amp; Skirt</a></h2>\n" +
"															<div class=\"actions\">\n" +
"																		<a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/add/uenc/aHR0cHM6Ly93d3cuYmFsbGV0c3R1ZmYuY29tLmF1Lw,,/product/6400/form_key/Qz98ZfFiF9N32dGf/\">\n" +
"								<button type=\"button\" class=\"button btn-cart msa\"><span><span>Add to Cart</span></span></button>\n" +
"							</a>\n" +
"																					</div>\n" +
"				</li>                    \n" +
"							<li class=\"onsaleproductslider-item\">\n" +
"					<a href=\"https://www.balletstuff.com.au/index.php/studio-range-ballet-tutu.html\" title=\"Studio Range Ballet Tutu\" class=\"product-image\"><img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/u/tutu_purple_f_3fcfe97f-5da5-4faa-b56f-6180e2626636_large_-_copy_-_copy.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range Ballet Tutu\" /></a>\n" +
"					<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-ballet-tutu.html\" title=\"Studio Range Ballet Tutu\">Studio Range Ballet Tutu</a></h2>\n" +
"															<div class=\"actions\">\n" +
"																		<a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/add/uenc/aHR0cHM6Ly93d3cuYmFsbGV0c3R1ZmYuY29tLmF1Lw,,/product/2075/form_key/Qz98ZfFiF9N32dGf/\">\n" +
"								<button type=\"button\" class=\"button btn-cart msa\"><span><span>Add to Cart</span></span></button>\n" +
"							</a>\n" +
"																					</div>\n" +
"				</li>                    \n" +
"							<li class=\"onsaleproductslider-item\">\n" +
"					<a href=\"https://www.balletstuff.com.au/index.php/stirrup-shimmer.html\" title=\"Shimmer Tights Light Flesh Stirrup\" class=\"product-image\"><img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_stirrup_shimmer_tights_light_flesh.jpg\" width=\"135\" height=\"135\" alt=\"Shimmer Tights Light Flesh Stirrup\" /></a>\n" +
"					<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/stirrup-shimmer.html\" title=\"Shimmer Tights Light Flesh Stirrup\">Shimmer Tights Light Flesh Stirrup</a></h2>\n" +
"															<div class=\"actions\">\n" +
"																		<a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/add/uenc/aHR0cHM6Ly93d3cuYmFsbGV0c3R1ZmYuY29tLmF1Lw,,/product/7816/form_key/Qz98ZfFiF9N32dGf/\">\n" +
"								<button type=\"button\" class=\"button btn-cart msa\"><span><span>Add to Cart</span></span></button>\n" +
"							</a>\n" +
"																					</div>\n" +
"				</li>                    \n" +
"</ul>\n" +
"<script type=\"text/javascript\">\n" +
"$jq('.ma-onsaleproductslider-container .flexslider').flexslider({\n" +
"slideshow: false,\n" +
"itemWidth: 230,\n" +
"itemMargin: 0,\n" +
"minItems: 1,\n" +
"maxItems: 3,\n" +
"slideshowSpeed: 3000,\n" +
"animationSpeed: 600,\n" +
"controlNav: false,\n" +
"animation: \"slide\"\n" +
"});\n" +
"</script>\n" +
"</div>	\n" +
" \n" +
"</div> \n" +
"<div class=\"block block-banner-left1\"><a href=\"https://www.balletstuff.com.au/index.php/accessories.html\"><img alt=\"\" src=\"https://www.balletstuff.com.au/media/wysiwyg/special-offer.jpg\" /></a></div>\n" +
"<div class=\"block block-banner-left1\"><a href=\"https://www.balletstuff.com.au/index.php/bulk-discount.html\"><img alt=\"\" src=\"https://www.balletstuff.com.au/media/wysiwyg/bulk-discounts.jpg\" /></a></div>                                                                                    </div>\n" +
"                            <div class=\"col-main span9\">\n" +
"                                                                	    <div class=\"ma-demo-wrap\">\n" +
"		<h2 class=\"ma-demo-title\">Theme Options</h2>\n" +
"		<div class=\"ma-demo-option\">\n" +
"			<div class=\"cl-wrapper\">\n" +
"				<div class=\"cl-container\">\n" +
"					<div class=\"cl-table\">\n" +
"						<div class=\"cl-tr cl-tr-style\">\n" +
"							<div class=\"cl-td-l cl-td-layout1\"><a href=\"https://www.balletstuff.com.au/index.php/?___store=english\" title=\"pink\" ><span></span>pink</a></div>\n" +
"							<div class=\"cl-td-r cl-td-layout2\"><a href=\"https://www.balletstuff.com.au/index.php/?___store=french\" title=\"red\"><span></span>red</a></div>\n" +
"						</div>\n" +
"						<div class=\"cl-tr cl-tr-style\">\n" +
"							<div class=\"cl-td-r cl-td-layout3\"><a href=\"https://www.balletstuff.com.au/index.php/?___store=br\" title=\"green\"><span></span>green</a></div>\n" +
"							<div class=\"cl-td-r cl-td-layout4\"><a href=\"https://www.balletstuff.com.au/index.php/?___store=pt\" title=\"orange\"><span></span>orange</a></div>\n" +
"						</div>\n" +
"						<div class=\"cl-tr cl-tr-style\">\n" +
"							<div class=\"cl-td-l cl-td-layout5\"><a href=\"https://www.balletstuff.com.au/index.php/?___store=it\" title=\"purple\"><span></span>purple</a></div>\n" +
"							<div class=\"cl-td-r cl-td-layout6\"><a href=\"https://www.balletstuff.com.au/index.php/?___store=au\" title=\"blue\"><span></span>blue</a></div>\n" +
"						</div>\n" +
"						\n" +
"						\n" +
"						\n" +
"                        <div class=\"cl-tr cl-row-reset\">\n" +
"                            <span class=\"cl-reset\"></span>\n" +
"                        </div>\n" +
"					</div>\n" +
"                </div>		\n" +
"			</div>\n" +
"		</div>\n" +
"		<div class=\"control inactive\"><a href=\"javascript:void(0)\"></a></div>\n" +
"		<script type=\"text/javascript\">\n" +
"			$jq(document).ready( function(){\n" +
"				$jq('.control').click(function(){\n" +
"					if($jq(this).hasClass('inactive')) {\n" +
"						$jq(this).removeClass('inactive');\n" +
"						$jq(this).addClass('active');\n" +
"						$jq('.ma-demo-wrap').animate({left:'0'}, 500);\n" +
"					} else {\n" +
"						$jq(this).addClass('inactive');\n" +
"						$jq('.ma-demo-wrap').animate({left:'-224px'}, 500);\n" +
"					}\n" +
"				});\n" +
"			});\n" +
"		</script>\n" +
"	</div>\n" +
"<script type=\"text/javascript\">\n" +
"//<![CDATA[    \n" +
"    $jq('#bodyBackgroundColor,#mainColor, #linkColor').each(function() {\n" +
"        var $jqel = $jq(this);\n" +
"        /* set time */\n" +
"        var date = new Date();\n" +
"        date.setTime(date.getTime() + (1440 * 60 * 1000));\n" +
"    \n" +
"        $jqel.ColorPicker({\n" +
"            color: '#0000ff',\n" +
"            onChange: function (hsb, hex, rgb) {\n" +
"    \n" +
"                $jqel.find('div').css('backgroundColor', '#' + hex);\n" +
"                switch ($jqel.attr(\"id\")) {			\n" +
"					\n" +
"                  case 'bodyBackgroundColor' :\n" +
"                    $jq(\"body\").css('backgroundColor', '#' + hex);\n" +
"                    // set cookie\n" +
"                    $jq.cookie('body_background_cookie', hex , { expires: date });\n" +
"                    break;\n" +
"				// main color\n" +
"				  case 'mainColor' :\n" +
"					$jq('<style type=\"text/css\">.ma-newproductslider-container .actions, .products-grid .actions, .ma-brand-slider-contain .flex-direction-nav a:hover, .ma-footer-static-container, .ma-nav-mobile-container, .ma-nav-container, .content-sample-block .block1 img, .productpage-sample-block .block2 img  { background-color:#'+hex+'}</style>').appendTo('head');\n" +
"					\n" +
"										$jq('<style type=\"text/css\">.product-view button.btn-cart:hover span { background-color:#'+hex+' !important}</style>').appendTo('head');\n" +
"\n" +
"					\n" +
"					$jq('<style type=\"text/css\">a:hover, .products-grid .product-name a:hover, .product-name a:hover { color:#'+hex+'}</style>').appendTo('head');\n" +
"					\n" +
"				  // set cookie\n" +
"				  $jq.cookie('main_color_cookie', hex , { expires: date });\n" +
"				  break;	\n" +
"				\n" +
"                  case 'linkColor' :\n" +
"                    //$jq(\"body a\").css('color', '#' + hex);\n" +
"					$jq('<style type=\"text/css\"> button.button span, .main button.btn-checkout:hover span, .header .form-search button.button:hover span, .ma-newproductslider-container .item-inner:hover .actions, .products-grid .item:hover .actions, .ma-brand-slider-contain .flex-direction-nav a, .ma-brand-slider-contain .flex-direction-nav .flex-next, .ma-new-vertscroller-wrap .jcarousel-next-vertical:hover, .ma-new-vertscroller-wrap .jcarousel-prev-vertical:hover, .add-to-cart input.qty-decrease:hover, .add-to-cart input.qty-increase:hover, .product-prev:hover, .product-next:hover, .ma-thumbnail-container .flex-direction-nav a:hover, .footer-freeshipping .shipping-icon, .wine_menu li.active a, .fish_menu li.active a, .wine_menu li.over a, .fish_menu li.over a, .wine_menu a:hover, .fish_menu a:hover, #back-top, .content-sample-block .block2 img, .productpage-sample-block .block1 img { background-color:#'+hex+'}</style>').appendTo('head');\n" +
"					\n" +
"					$jq('<style type=\"text/css\"> button.btn-cart:hover span, .product-view button.btn-cart span, .ui-slider .ui-slider-range { background-color:#'+hex+' !important}</style>').appendTo('head');\n" +
"					\n" +
"					$jq('<style type=\"text/css\"> a, .breadcrumbs li strong, .pager .pages a:hover, .pager .pages .current, .header .welcome-msg a, .header .currency-language .language-switcher a:hover, .header .links li a:hover, .top-cart-contain .price, .block .block-title strong .word2, .block-right-static .block-title strong, .block-subscribe-right .block-title strong, .block-account .block-content li a:hover, .block-account .block-content li.current, .block-layered-nav li:hover, .block-layered-nav li a:hover, .ma-featured-product-title h2 .word2, .ma-newproductslider-title h2 .word2, .products-list .product-name a:hover, .product-view .product-shop .availability span, .price-box .price, .regular-price, .regular-price .price, .block .regular-price, .block .regular-price .price, .special-price .price-label, .special-price .price, .add-to-cart .qty, .product-collateral h2 .word2, .product-view .product-shop .product-sku span, .product-view .product-shop .product-brand span, .product-view .product-shop .add-to-links a:hover, .email-friend a:hover, .ma-footer-static .fcol1 li:hover, .ma-footer-static .fcol1 li a:hover, .mobilemenu li.active a, .mobilemenu a:hover, #ticker a { color:#'+hex+'}</style>').appendTo('head');\n" +
"					\n" +
"					$jq('<style type=\"text/css\"> .mobilemenu ul a:hover, .mobilemenu ul li.active a, .mobilemenu ul ul a:hover, .mobilemenu ul ul li.active a, .mobilemenu ul li.active ul a:hover, .mobilemenu ul ul ul a:hover, .mobilemenu ul ul ul li.active a, .mobilemenu ul ul li.active ul a:hover, .mobilemenu ul ul ul ul a:hover, .mobilemenu ul ul ul ul li.active a, .mobilemenu ul ul ul li.active ul a:hover, .wine_menu ul li a:hover, .wine_menu ul ul li a:hover, .fish_menu ul li a:hover { color:#'+hex+' !important}</style>').appendTo('head');\n" +
"					$jq('<style type=\"text/css\">.ma-newproductslider-container .item-inner:hover, .ma-newproductslider-container .item-inner:hover, .product-tabs a:hover, .product-tabs li.active a, .product-tabs li.active a:hover, .wine_menu .container, .fish_menu ul, .fish_menu div, .fish_menu ul ul, .fish_menu ul div { border-color:#'+hex+'}</style>').appendTo('head');\n" +
"					\n" +
"                    // set cookie\n" +
"                    $jq.cookie('link_color_cookie', hex , { expires: date });\n" +
"                    break;			\n" +
"				\n" +
"                }\n" +
"            }\n" +
"        });\n" +
"    });\n" +
"    /* set time */\n" +
"    var date = new Date();\n" +
"    date.setTime(date.getTime() + (1440 * 60 * 1000));\n" +
"	\n" +
"			\n" +
"	$jq(document).ready(function(){\n" +
"		\n" +
"		//load selected font\n" +
"		$jq(\"#select-fontselector option\").filter(function() {\n" +
"			//may want to use $.trim in here\n" +
"			return $jq(this).text() == $jq.cookie('font_cookie'); \n" +
"		}).attr('selected', true);\n" +
"		//change font\n" +
"		$jq(function(){\n" +
"			fontSelect=$jq(\"#select-fontselector\");\n" +
"			fontUpdate=function(){\n" +
"				curFont=$jq(\"#select-fontselector\").val();\n" +
"				$jq(\".page-title h1, .page-title h2, .block .block-title strong, .block-right-static .block-title h3, .block-subscribe-right .block-title h3, .ma-mostviewed-product-title h2, .ma-upsellslider-container .product-name, .ma-newproductslider-container .product-name, .products-grid .product-name, .ma-featured-product-title h2, .ma-newproductslider-title h2, .products-list .product-name, .product-collateral h2, .product-view .product-shop .product-name h1, .product-view .box-up-sell h2, .footer-freeshipping h3, .footer-subscribe .form-subscribe-header h4, .ma-footer-static .footer-static-title h3, .product-tabs a, .wine_menu a, .fish_menu a, .wine_menu ul li a \").css({ fontFamily: curFont });\n" +
"				$jq(\"<link />\",{href:\"https://fonts.googleapis.com/css?family=\"+curFont,rel:\"stylesheet\",type:\"text/css\"}).appendTo(\"head\");\n" +
"			}\n" +
"			fontSelect.change(function(){\n" +
"				fontUpdate();\n" +
"			}).keyup(function(){\n" +
"				fontUpdate();\n" +
"			}).keydown(function(){\n" +
"				fontUpdate();\n" +
"			});\n" +
"			\n" +
"			$jq(\"#select-fontselector\").trigger(\"change\");\n" +
"		})\n" +
"		\n" +
"		$jq('#select-fontselector').change(function() {\n" +
"			$jq.cookie('font_cookie', $jq(this).val(), { expires: date });\n" +
"		});\n" +
"		$jq(\".page-title h1, .page-title h2, .block .block-title strong, .block-right-static .block-title h3, .block-subscribe-right .block-title h3, .ma-mostviewed-product-title h2, .ma-upsellslider-container .product-name, .ma-newproductslider-container .product-name, .products-grid .product-name, .ma-featured-product-title h2, .ma-newproductslider-title h2, .products-list .product-name, .product-collateral h2, .product-view .product-shop .product-name h1, .product-view .box-up-sell h2, .footer-freeshipping h3, .footer-subscribe .form-subscribe-header h4, .ma-footer-static .footer-static-title h3, .product-tabs a, .wine_menu a, .fish_menu a, .wine_menu ul li a\").css({ fontFamily: $jq.cookie('font_cookie') }); \n" +
"		$jq(\"<link />\",{href:\"https://fonts.googleapis.com/css?family=\"+$jq.cookie('font_cookie'),rel:\"stylesheet\",type:\"text/css\"}).appendTo(\"head\");\n" +
"		\n" +
"		//set cookie\n" +
"		$jq(\"body\").css('backgroundColor', '#ffffff');\n" +
"		$jq(\"body\").css('background-image', $jq.cookie('body_image_cookie'));\n" +
"		$jq(\"body\").css('background-repeat','repeat');\n" +
"		\n" +
"		// main color\n" +
"\n" +
"		$jq('<style type=\"text/css\">.ma-newproductslider-container .actions, .products-grid .actions, .ma-brand-slider-contain .flex-direction-nav a:hover, .ma-footer-static-container, .ma-nav-mobile-container, .ma-nav-container, .content-sample-block .block1 img, .productpage-sample-block .block2 img  { background-color:#'+$jq.cookie('main_color_cookie')+'}</style>').appendTo('head');\n" +
"		\n" +
"							$jq('<style type=\"text/css\">.product-view button.btn-cart:hover span { background-color:#'+$jq.cookie('main_color_cookie')+' !important}</style>').appendTo('head');\n" +
"\n" +
"		\n" +
"		$jq('<style type=\"text/css\">a:hover, .products-grid .product-name a:hover, .product-name a:hover { color:#'+$jq.cookie('main_color_cookie')+'}</style>').appendTo('head');\n" +
"					\n" +
"		\n" +
"		//link color\n" +
"		$jq('<style type=\"text/css\">button.button span, .main button.btn-checkout:hover span, .header .form-search button.button:hover span, .ma-newproductslider-container .item-inner:hover .actions, .products-grid .item:hover .actions, .ma-brand-slider-contain .flex-direction-nav a, .ma-brand-slider-contain .flex-direction-nav .flex-next, .ma-new-vertscroller-wrap .jcarousel-next-vertical:hover, .ma-new-vertscroller-wrap .jcarousel-prev-vertical:hover, .add-to-cart input.qty-decrease:hover, .add-to-cart input.qty-increase:hover, .product-prev:hover, .product-next:hover, .ma-thumbnail-container .flex-direction-nav a:hover, .footer-freeshipping .shipping-icon, .wine_menu li.active a, .fish_menu li.active a, .wine_menu li.over a, .fish_menu li.over a, .wine_menu a:hover, .fish_menu a:hover, #back-top, .content-sample-block .block2 img, .productpage-sample-block .block1 img  { background-color:#'+$jq.cookie('link_color_cookie')+'}</style>').appendTo('head');\n" +
"		$jq('<style type=\"text/css\"> button.btn-cart:hover span, .product-view button.btn-cart span, .ui-slider .ui-slider-range { background-color:#'+$jq.cookie('link_color_cookie')+' !important}</style>').appendTo('head');\n" +
"		\n" +
"		$jq('<style type=\"text/css\">a, .breadcrumbs li strong, .pager .pages a:hover, .pager .pages .current, .header .welcome-msg a, .header .currency-language .language-switcher a:hover, .header .links li a:hover, .top-cart-contain .price, .block .block-title strong .word2, .block-right-static .block-title strong, .block-subscribe-right .block-title strong, .block-account .block-content li a:hover, .block-account .block-content li.current, .block-layered-nav li:hover, .block-layered-nav li a:hover, .ma-featured-product-title h2 .word2, .ma-newproductslider-title h2 .word2, .products-list .product-name a:hover, .product-view .product-shop .availability span, .price-box .price, .regular-price, .regular-price .price, .block .regular-price, .block .regular-price .price, .special-price .price-label, .special-price .price, .add-to-cart .qty, .product-collateral h2 .word2, .product-view .product-shop .product-sku span, .product-view .product-shop .product-brand span, .product-view .product-shop .add-to-links a:hover, .email-friend a:hover, .ma-footer-static .fcol1 li:hover, .ma-footer-static .fcol1 li a:hover, .mobilemenu li.active a, .mobilemenu a:hover, #ticker a  { color:#'+$jq.cookie('link_color_cookie')+'}</style>').appendTo('head');\n" +
"		$jq('<style type=\"text/css\">.mobilemenu ul a:hover, .mobilemenu ul li.active a, .mobilemenu ul ul a:hover, .mobilemenu ul ul li.active a, .mobilemenu ul li.active ul a:hover, .mobilemenu ul ul ul a:hover, .mobilemenu ul ul ul li.active a, .mobilemenu ul ul li.active ul a:hover, .mobilemenu ul ul ul ul a:hover, .mobilemenu ul ul ul ul li.active a, .mobilemenu ul ul ul li.active ul a:hover, .wine_menu ul li a:hover, .wine_menu ul ul li a:hover, .fish_menu ul li a:hover { color:#'+$jq.cookie('link_color_cookie')+' !important}</style>').appendTo('head');\n" +
"		\n" +
"		$jq('<style type=\"text/css\"> .ma-newproductslider-container .item-inner:hover, .ma-newproductslider-container .item-inner:hover, .product-tabs a:hover, .product-tabs li.active a, .product-tabs li.active a:hover, .wine_menu .container, .fish_menu ul, .fish_menu div, .fish_menu ul ul, .fish_menu ul div { border-color:#'+$jq.cookie('link_color_cookie')+'}</style>').appendTo('head');\n" +
"		\n" +
"		//set background image\n" +
"		$jq('.cl-pattern div').click(function(){\n" +
"			$jq(\"body\").css('background-image', 'url(https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/colortool/images/pattern/'+this.id+'.png)');\n" +
"			$jq(\"body\").css('background-repeat','repeat');\n" +
"			$jq.cookie('body_image_cookie', 'url(https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/colortool/images/pattern/'+this.id+'.png)', { expires: date });\n" +
"		});\n" +
"	\n" +
"		//set cookie for theme color\n" +
"		var cl = $jq(\".cl-row-themeskin\");\n" +
"		cl.find(\"a\").each(function() {\n" +
"			$jq(this).click(function(){\n" +
"				$jq.cookie('style_color', $jq(this).attr('title') , { expires: date });\n" +
"				location.reload();\n" +
"			});\n" +
"		});\n" +
"	});\n" +
"		\n" +
"	\n" +
"    //reset button\n" +
"    $jq('.cl-reset').click(function(){\n" +
"		\n" +
"		$jq.cookie('font_cookie','');\n" +
"		$jq.cookie('main_color_cookie','');\n" +
"		$jq.cookie('link_color_cookie','');\n" +
"		\n" +
"        $jq.cookie('body_image_cookie','');	\n" +
"		$jq(\"body\").css('background-image', 'url(https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop/magentothem/colortool/images/pattern/)');\n" +
"		\n" +
"        $jq.cookie('body_background_cookie','');\n" +
"        $jq(\"body\").css('backgroundColor', '#');\n" +
"		location.reload();\n" +
"    });\n" +
"//]]>\n" +
"</script><div class=\"std\"><div class=\"home-content\">	<div class=\"ma-featuredproductslider-container\">\n" +
"			<div class=\"ma-featured-sldier-title\"><h2>Featured Products</h2></div>\n" +
"	 \n" +
"		<div class=\"flexslider carousel\">\n" +
"			<ul class=\"slides\">\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/leather-ballet-shoes-pink-split-sole.html\" title=\"Ballet Shoes Leather (Pink) - Split Sole \">Ballet Shoes Leather (Pink) - Split Sole </a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$18.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/leather-ballet-shoes-pink-split-sole.html\" title=\"Ballet Shoes Leather (Pink) - Split Sole \">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballet_shoes_pink_split_sole_1.jpg\" width=\"135\" height=\"135\" alt=\"Ballet Shoes Leather (Pink) - Split Sole \" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/mary-jane-tap-shoes-black.html\" title=\"Mary Jane Tap Shoes (Black)\">Mary Jane Tap Shoes (Black)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$45.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/mary-jane-tap-shoes-black.html\" title=\"Mary Jane Tap Shoes (Black)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/m/a/mary-jane-tap-shoes-black.jpg\" width=\"135\" height=\"135\" alt=\"Mary Jane Tap Shoes (Black)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-works-shoes-leotard-tights-skirt-xover-headband.html\" title=\"STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)\">STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$75.56</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-works-shoes-leotard-tights-skirt-xover-headband.html\" title=\"STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff-studio-range-works1.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/best-seller-ballet-pack-shoes-leotard-tights-skirt.html\" title=\"BEST SELLER Ballet Pack: Shoes Leotard Tights &amp; Skirt (Pink or Black)\">BEST SELLER Ballet Pack: Shoes Leotard Tights &amp; Skirt (Pink or Black)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$40.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/best-seller-ballet-pack-shoes-leotard-tights-skirt.html\" title=\"BEST SELLER Ballet Pack: Shoes Leotard Tights &amp; Skirt (Pink or Black)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff-best-seller-ballet-pack1.jpg\" width=\"135\" height=\"135\" alt=\"BEST SELLER Ballet Pack: Shoes Leotard Tights &amp; Skirt (Pink or Black)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/premium-leather-jazz-shoe-split-sole.html\" title=\"Premium Leather Jazz Shoe - Split Sole - Black &amp; Tan \">Premium Leather Jazz Shoe - Split Sole - Black &amp; Tan </a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$29.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/premium-leather-jazz-shoe-split-sole.html\" title=\"Premium Leather Jazz Shoe - Split Sole - Black &amp; Tan \">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/d/0/d004715_1.jpg\" width=\"135\" height=\"135\" alt=\"Premium Leather Jazz Shoe - Split Sole - Black &amp; Tan \" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-ballet-concert-tutu.html\" title=\"Studio Range Ballet Concert Tutu\">Studio Range Ballet Concert Tutu</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$39.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-ballet-concert-tutu.html\" title=\"Studio Range Ballet Concert Tutu\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/8/4/84302067_200x200.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range Ballet Concert Tutu\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/convertible-ballet-tights-bulk-3-pairs.html\" title=\"Convertible Ballet Tights BULK 3 PAIRS (Pink, Tan, Flesh, Black, White)\">Convertible Ballet Tights BULK 3 PAIRS (Pink, Tan, Flesh, Black, White)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$20.90</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/convertible-ballet-tights-bulk-3-pairs.html\" title=\"Convertible Ballet Tights BULK 3 PAIRS (Pink, Tan, Flesh, Black, White)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/p/r/prima-pink-convertible-tights.jpg\" width=\"135\" height=\"135\" alt=\"Convertible Ballet Tights BULK 3 PAIRS (Pink, Tan, Flesh, Black, White)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/black-camisole-leotard.html\" title=\"Black Camisole Leotard\">Black Camisole Leotard</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$21.77</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/black-camisole-leotard.html\" title=\"Black Camisole Leotard\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/l/black-camisole-leotard.jpg\" width=\"135\" height=\"135\" alt=\"Black Camisole Leotard\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/black-convertible-tights-overstocked-sale-online-only.html\" title=\"Black Convertible Tights OVERSTOCKED SALE Online Only\">Black Convertible Tights OVERSTOCKED SALE Online Only</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$5.01</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/black-convertible-tights-overstocked-sale-online-only.html\" title=\"Black Convertible Tights OVERSTOCKED SALE Online Only\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/l/black_convertible_tights_1.jpg\" width=\"135\" height=\"135\" alt=\"Black Convertible Tights OVERSTOCKED SALE Online Only\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/tutu-singlet-dress-light-pink-flash-sale-special.html\" title=\"Tutu Singlet Dress Light Pink FLASH SALE SPECIAL\">Tutu Singlet Dress Light Pink FLASH SALE SPECIAL</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$15.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/tutu-singlet-dress-light-pink-flash-sale-special.html\" title=\"Tutu Singlet Dress Light Pink FLASH SALE SPECIAL\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/f/g/fg191-lp_1.gif\" width=\"135\" height=\"135\" alt=\"Tutu Singlet Dress Light Pink FLASH SALE SPECIAL\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/sparkle-tutu-skirt.html\" title=\"Sparkle Tutu Skirt - 6 Colours\">Sparkle Tutu Skirt - 6 Colours</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$10.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/sparkle-tutu-skirt.html\" title=\"Sparkle Tutu Skirt - 6 Colours\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/i/m/img_5694.jpg\" width=\"135\" height=\"135\" alt=\"Sparkle Tutu Skirt - 6 Colours\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/premium-leather-slip-on-jazz-bootie-black-tan.html\" title=\"Jazz Bootie - Premium Leather Slip on - Black\">Jazz Bootie - Premium Leather Slip on - Black</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$43.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/premium-leather-slip-on-jazz-bootie-black-tan.html\" title=\"Jazz Bootie - Premium Leather Slip on - Black\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/j/a/jazz_booties.jpg\" width=\"135\" height=\"135\" alt=\"Jazz Bootie - Premium Leather Slip on - Black\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/sparkle-tutu-skirt-7814.html\" title=\"Sweetheart Singlet Top : 6-7 years\">Sweetheart Singlet Top : 6-7 years</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.75</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/sparkle-tutu-skirt-7814.html\" title=\"Sweetheart Singlet Top : 6-7 years\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/w/sweethearts-singlet-420x420.jpg\" width=\"135\" height=\"135\" alt=\"Sweetheart Singlet Top : 6-7 years\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/singlettop.html\" title=\"Sweetheart Singlet Top : 4-5 years\">Sweetheart Singlet Top : 4-5 years</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.75</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/singlettop.html\" title=\"Sweetheart Singlet Top : 4-5 years\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/w/sweethearts-singlet-420x420_1.jpg\" width=\"135\" height=\"135\" alt=\"Sweetheart Singlet Top : 4-5 years\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/sparkle-tutu-skirt-7815.html\" title=\"Sweetheart Singlet Top : 2-3 years\">Sweetheart Singlet Top : 2-3 years</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.75</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/sparkle-tutu-skirt-7815.html\" title=\"Sweetheart Singlet Top : 2-3 years\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/w/sweethearts-singlet-420x420_2.jpg\" width=\"135\" height=\"135\" alt=\"Sweetheart Singlet Top : 2-3 years\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/best-seller-ballet-pack-shoes-leotard-tights-skirt-7911.html\" title=\"VALUE Ballet Pack: Shoes Leotard Socks &amp; Skirt (Pink or Black)\">VALUE Ballet Pack: Shoes Leotard Socks &amp; Skirt (Pink or Black)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$35.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/best-seller-ballet-pack-shoes-leotard-tights-skirt-7911.html\" title=\"VALUE Ballet Pack: Shoes Leotard Socks &amp; Skirt (Pink or Black)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff-best-seller-ballet-pack1_2.jpg\" width=\"135\" height=\"135\" alt=\"VALUE Ballet Pack: Shoes Leotard Socks &amp; Skirt (Pink or Black)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/oxford-leather-tap-shoe-black.html\" title=\"Oxford Leather Tap Shoe (Black)\">Oxford Leather Tap Shoe (Black)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$66.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/oxford-leather-tap-shoe-black.html\" title=\"Oxford Leather Tap Shoe (Black)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/o/x/oxford_taps4_1_1.jpg\" width=\"135\" height=\"135\" alt=\"Oxford Leather Tap Shoe (Black)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/kookies-n-kream-ballet-pack.html\" title=\"Kookies N Kream Ballet Pack\">Kookies N Kream Ballet Pack</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$55.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/kookies-n-kream-ballet-pack.html\" title=\"Kookies N Kream Ballet Pack\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_studio_range_works1.jpg\" width=\"135\" height=\"135\" alt=\"Kookies N Kream Ballet Pack\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/premium-leather-slip-on-jazz-bootie-black-tan-7976.html\" title=\"Jazz Bootie - Premium Leather Slip on - Tan \">Jazz Bootie - Premium Leather Slip on - Tan </a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$43.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/premium-leather-slip-on-jazz-bootie-black-tan-7976.html\" title=\"Jazz Bootie - Premium Leather Slip on - Tan \">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/f/c/fcf44b_bb7c34ed79f3f5dba63b01cc8fc33e8d_jpg_srz_270_215_75_22_0_50_1_20_0_1.jpg\" width=\"135\" height=\"135\" alt=\"Jazz Bootie - Premium Leather Slip on - Tan \" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/internet-only-special-leather-ballet-shoes-clearance.html\" title=\"INTERNET ONLY SPECIAL Leather Ballet Shoes Clearance\">INTERNET ONLY SPECIAL Leather Ballet Shoes Clearance</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/internet-only-special-leather-ballet-shoes-clearance.html\" title=\"INTERNET ONLY SPECIAL Leather Ballet Shoes Clearance\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballet_shoes_larger_sizes.jpg\" width=\"135\" height=\"135\" alt=\"INTERNET ONLY SPECIAL Leather Ballet Shoes Clearance\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/chiffon-style-skirt-elastic-wiast-clearance-internet-only.html\" title=\"Chiffon Style Skirt Elastic Waist CLEARANCE INTERNET ONLY\">Chiffon Style Skirt Elastic Waist CLEARANCE INTERNET ONLY</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$4.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/chiffon-style-skirt-elastic-wiast-clearance-internet-only.html\" title=\"Chiffon Style Skirt Elastic Waist CLEARANCE INTERNET ONLY\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_chiffon_look_skirt_clearance1.jpg\" width=\"135\" height=\"135\" alt=\"Chiffon Style Skirt Elastic Waist CLEARANCE INTERNET ONLY\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/polka-dot-skirt-hot-pink-clearance-cost-price.html\" title=\"Polka Dot Skirt Hot Pink - CLEARANCE COST PRICE - LIMITED STOCK\">Polka Dot Skirt Hot Pink - CLEARANCE COST PRICE - LIMITED STOCK</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$8.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/polka-dot-skirt-hot-pink-clearance-cost-price.html\" title=\"Polka Dot Skirt Hot Pink - CLEARANCE COST PRICE - LIMITED STOCK\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/f/s/fs164_2_1.jpg\" width=\"135\" height=\"135\" alt=\"Polka Dot Skirt Hot Pink - CLEARANCE COST PRICE - LIMITED STOCK\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-pale-pink-circle-skirts-2-3-years-clearance.html\" title=\"Studio Range Pale Pink Circle Skirts - 2-3 years CLEARANCE\">Studio Range Pale Pink Circle Skirts - 2-3 years CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-pale-pink-circle-skirts-2-3-years-clearance.html\" title=\"Studio Range Pale Pink Circle Skirts - 2-3 years CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/t/studio_range_pale_pink_pack.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range Pale Pink Circle Skirts - 2-3 years CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/baby-tutu-6-9-months-clearance.html\" title=\"Baby Tutu 6-9 months CLEARANCE\">Baby Tutu 6-9 months CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$12.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/baby-tutu-6-9-months-clearance.html\" title=\"Baby Tutu 6-9 months CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_ballerina_pack1.jpg\" width=\"135\" height=\"135\" alt=\"Baby Tutu 6-9 months CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/gathered-front-navy-leotard-2-3-years-clearance.html\" title=\"Gathered front navy leotard - 2-3 years CLEARANCE\">Gathered front navy leotard - 2-3 years CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$12.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/gathered-front-navy-leotard-2-3-years-clearance.html\" title=\"Gathered front navy leotard - 2-3 years CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/c/tcl01_nvy_f_large_2.jpg\" width=\"135\" height=\"135\" alt=\"Gathered front navy leotard - 2-3 years CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/sequin-tutu-dress.html\" title=\"Sequin Tutu Dress\">Sequin Tutu Dress</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$46.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/sequin-tutu-dress.html\" title=\"Sequin Tutu Dress\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/e/sequin_tutu_dress_pink_1.jpg\" width=\"135\" height=\"135\" alt=\"Sequin Tutu Dress\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/sequin-tutu-dress-7822.html\" title=\"Sequin Lyrical Dress - Child\">Sequin Lyrical Dress - Child</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$42.96</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/sequin-tutu-dress-7822.html\" title=\"Sequin Lyrical Dress - Child\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/e/sequin_lyrical_dress_hot_pink.jpg\" width=\"135\" height=\"135\" alt=\"Sequin Lyrical Dress - Child\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/classic-dance-sneaker.html\" title=\"Classic Dance Sneaker\">Classic Dance Sneaker</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$45.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/classic-dance-sneaker.html\" title=\"Classic Dance Sneaker\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_jazz_sneakers_1.jpg\" width=\"135\" height=\"135\" alt=\"Classic Dance Sneaker\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/candy-pink-ballet-tights.html\" title=\"Candy Pink Ballet Tights\">Candy Pink Ballet Tights</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.96</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/candy-pink-ballet-tights.html\" title=\"Candy Pink Ballet Tights\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/c/a/candy_pink_tights.jpg\" width=\"135\" height=\"135\" alt=\"Candy Pink Ballet Tights\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/dance-exercise-band-pink.html\" title=\"Dance Exercise Band Pink\">Dance Exercise Band Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.50</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/dance-exercise-band-pink.html\" title=\"Dance Exercise Band Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_dance_resistance_band.jpg\" width=\"135\" height=\"135\" alt=\"Dance Exercise Band Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/extra-strength-seamless-hair-elastics-pack-5.html\" title=\"Extra Strength Seamless Hair Elastics - Pack 5\">Extra Strength Seamless Hair Elastics - Pack 5</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$1.65</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/extra-strength-seamless-hair-elastics-pack-5.html\" title=\"Extra Strength Seamless Hair Elastics - Pack 5\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/h/a/hair_elastics.jpg\" width=\"135\" height=\"135\" alt=\"Extra Strength Seamless Hair Elastics - Pack 5\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/black-singlet-tutu.html\" title=\"Black singlet tutu\">Black singlet tutu</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$24.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/black-singlet-tutu.html\" title=\"Black singlet tutu\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/5/2/526_fairy_girls_260211_2.jpg\" width=\"135\" height=\"135\" alt=\"Black singlet tutu\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/lace-lyrical-dress.html\" title=\"Lace Lyrical Dress - Child\">Lace Lyrical Dress - Child</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$46.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/lace-lyrical-dress.html\" title=\"Lace Lyrical Dress - Child\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/l/a/lace_lyrical_dress_red_1024x1024.jpg\" width=\"135\" height=\"135\" alt=\"Lace Lyrical Dress - Child\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/lace-lyrical-dress-7806.html\" title=\"Lace Lyrical Dress - Adult\">Lace Lyrical Dress - Adult</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$58.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/lace-lyrical-dress-7806.html\" title=\"Lace Lyrical Dress - Adult\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/l/a/lace_lycra_dress_1024x1024_1.jpg\" width=\"135\" height=\"135\" alt=\"Lace Lyrical Dress - Adult\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/sequin-tutu-dress-7823.html\" title=\"Sequin Lyrical Dress - Adult\">Sequin Lyrical Dress - Adult</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$56.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/sequin-tutu-dress-7823.html\" title=\"Sequin Lyrical Dress - Adult\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/e/sequin_lyrical_dress_turquoise_1_1.jpg\" width=\"135\" height=\"135\" alt=\"Sequin Lyrical Dress - Adult\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/two-hole-foot-thong.html\" title=\"Two Hole Foot Thong\">Two Hole Foot Thong</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$12.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/two-hole-foot-thong.html\" title=\"Two Hole Foot Thong\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/w/two_hole_foot_thong.jpg\" width=\"135\" height=\"135\" alt=\"Two Hole Foot Thong\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/black-chiffon-skirt.html\" title=\"Black Chiffon Skirt\">Black Chiffon Skirt</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.96</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/black-chiffon-skirt.html\" title=\"Black Chiffon Skirt\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/l/black_chiffon_skirt.jpg\" width=\"135\" height=\"135\" alt=\"Black Chiffon Skirt\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/premium-leather-slip-on-jazz-bootie-black-tan-7977.html\" title=\"Premium Leather Slip on Jazz Bootie - Tan - LARGE SIZE CLEARANCE INTERNET ONLY\">Premium Leather Slip on Jazz Bootie - Tan - LARGE SIZE CLEARANCE INTERNET ONLY</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$25.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/premium-leather-slip-on-jazz-bootie-black-tan-7977.html\" title=\"Premium Leather Slip on Jazz Bootie - Tan - LARGE SIZE CLEARANCE INTERNET ONLY\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/f/c/fcf44b_bb7c34ed79f3f5dba63b01cc8fc33e8d_jpg_srz_270_215_75_22_0_50_1_20_0_1_1.jpg\" width=\"135\" height=\"135\" alt=\"Premium Leather Slip on Jazz Bootie - Tan - LARGE SIZE CLEARANCE INTERNET ONLY\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/canvas-ballet-shoe-split-sole.html\" title=\"Canvas Ballet Shoe Split Sole\">Canvas Ballet Shoe Split Sole</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.96</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/canvas-ballet-shoe-split-sole.html\" title=\"Canvas Ballet Shoe Split Sole\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/c/a/canvas_ballet_shoes_balletstuff.jpg\" width=\"135\" height=\"135\" alt=\"Canvas Ballet Shoe Split Sole\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/ballet-tutu-for-2-year-old-lilac-or-hot-pink.html\" title=\"Ballet Tutu for 2 Year Old - Lilac or Hot Pink\">Ballet Tutu for 2 Year Old - Lilac or Hot Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$12.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/ballet-tutu-for-2-year-old-lilac-or-hot-pink.html\" title=\"Ballet Tutu for 2 Year Old - Lilac or Hot Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballet_tutu_lilac.jpg\" width=\"135\" height=\"135\" alt=\"Ballet Tutu for 2 Year Old - Lilac or Hot Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/light-flesh-shimmer-tights-womens-size-8-10.html\" title=\"Light Flesh Shimmer Tights \">Light Flesh Shimmer Tights </a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.56</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/light-flesh-shimmer-tights-womens-size-8-10.html\" title=\"Light Flesh Shimmer Tights \">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/l/i/light_flesh_shimmer_tights.jpg\" width=\"135\" height=\"135\" alt=\"Light Flesh Shimmer Tights \" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-gathered-front-leotard-sale.html\" title=\"STUDIO RANGE Gathered Front Leotard Sale - Pink, White\">STUDIO RANGE Gathered Front Leotard Sale - Pink, White</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$17.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-gathered-front-leotard-sale.html\" title=\"STUDIO RANGE Gathered Front Leotard Sale - Pink, White\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/c/h/chl01-fr-0005.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE Gathered Front Leotard Sale - Pink, White\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-rad-exam-pack.html\" title=\"Studio Range RAD Exam Pack\">Studio Range RAD Exam Pack</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$79.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-rad-exam-pack.html\" title=\"Studio Range RAD Exam Pack\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_studio_range_exam_skirt_pack.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range RAD Exam Pack\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/black-singlet-7815.html\" title=\"Black Singlet\">Black Singlet</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$14.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/black-singlet-7815.html\" title=\"Black Singlet\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/l/black-singlet_2.jpg\" width=\"135\" height=\"135\" alt=\"Black Singlet\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/whiteleo.html\" title=\"White Gathered Front Leotard Sale\">White Gathered Front Leotard Sale</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$14.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/whiteleo.html\" title=\"White Gathered Front Leotard Sale\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/c/tcl01_wht_f_large_2_1.jpg\" width=\"135\" height=\"135\" alt=\"White Gathered Front Leotard Sale\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/warm-up-boots.html\" title=\"Warm up Boots\">Warm up Boots</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$29.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/warm-up-boots.html\" title=\"Warm up Boots\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/w/a/warm_up_boots_1.jpg\" width=\"135\" height=\"135\" alt=\"Warm up Boots\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/clearance-pink-crossover.html\" title=\"Clearance Pink Crossover\">Clearance Pink Crossover</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$15.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/clearance-pink-crossover.html\" title=\"Clearance Pink Crossover\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_budget_crossover.jpg\" width=\"135\" height=\"135\" alt=\"Clearance Pink Crossover\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/twinklin-star-dance-studios-tutu.html\" title=\"Twinkling Star Dance Studios Tutu\">Twinkling Star Dance Studios Tutu</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/twinklin-star-dance-studios-tutu.html\" title=\"Twinkling Star Dance Studios Tutu\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/f/s/fs156_1_3.jpg\" width=\"135\" height=\"135\" alt=\"Twinkling Star Dance Studios Tutu\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/warm-up-boots-7818.html\" title=\"Warm up Boots Navy\">Warm up Boots Navy</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$29.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/warm-up-boots-7818.html\" title=\"Warm up Boots Navy\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/w/a/warm_up_boots_7.jpg\" width=\"135\" height=\"135\" alt=\"Warm up Boots Navy\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/contemporary-leather-half-shoe.html\" title=\"Contemporary Leather Half Shoe\">Contemporary Leather Half Shoe</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$14.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/contemporary-leather-half-shoe.html\" title=\"Contemporary Leather Half Shoe\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/h/a/half_shoe_1.jpg\" width=\"135\" height=\"135\" alt=\"Contemporary Leather Half Shoe\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/contemporary-leather-half-shoe-7813.html\" title=\"Contemporary Canvas Half Shoe - Tan\">Contemporary Canvas Half Shoe - Tan</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$14.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/contemporary-leather-half-shoe-7813.html\" title=\"Contemporary Canvas Half Shoe - Tan\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/h/a/half_shoe_canvas1.jpg\" width=\"135\" height=\"135\" alt=\"Contemporary Canvas Half Shoe - Tan\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/stirrup-fishnet-tights-black-womens.html\" title=\"Stirrup Fishnet Tights Black - Womens\">Stirrup Fishnet Tights Black - Womens</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$11.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/stirrup-fishnet-tights-black-womens.html\" title=\"Stirrup Fishnet Tights Black - Womens\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/e/seamless_fishnet_stirrup_tights_black.jpg\" width=\"135\" height=\"135\" alt=\"Stirrup Fishnet Tights Black - Womens\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/silver-ballet-shoes.html\" title=\"Silver Ballet Shoes\">Silver Ballet Shoes</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/silver-ballet-shoes.html\" title=\"Silver Ballet Shoes\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_silber_ballet_shoes.jpg\" width=\"135\" height=\"135\" alt=\"Silver Ballet Shoes\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/toast-shimmer-tights.html\" title=\"Shimmer Tights \">Shimmer Tights </a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.56</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/toast-shimmer-tights.html\" title=\"Shimmer Tights \">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/h/shimmer-tights.jpg\" width=\"135\" height=\"135\" alt=\"Shimmer Tights \" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-wrap-skirt-ballet-pink.html\" title=\"STUDIO RANGE WRAP Skirt Ballet Pink\">STUDIO RANGE WRAP Skirt Ballet Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$14.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-wrap-skirt-ballet-pink.html\" title=\"STUDIO RANGE WRAP Skirt Ballet Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/c/tcws01_bpk.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE WRAP Skirt Ballet Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/dance-duffel-bag-7817.html\" title=\"Dance Duffel Bag\">Dance Duffel Bag</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$29.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/dance-duffel-bag-7817.html\" title=\"Dance Duffel Bag\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/i/silver_dance_duffel_bag.jpg\" width=\"135\" height=\"135\" alt=\"Dance Duffel Bag\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/stirrup-shimmer.html\" title=\"Shimmer Tights Light Flesh Stirrup\">Shimmer Tights Light Flesh Stirrup</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$11.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/stirrup-shimmer.html\" title=\"Shimmer Tights Light Flesh Stirrup\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_stirrup_shimmer_tights_light_flesh.jpg\" width=\"135\" height=\"135\" alt=\"Shimmer Tights Light Flesh Stirrup\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/clearance-budget-black-ballet-shoes.html\" title=\"Clearance Budget Black Ballet Shoes WHILE STOCKS LAST!\">Clearance Budget Black Ballet Shoes WHILE STOCKS LAST!</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$10.98</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/clearance-budget-black-ballet-shoes.html\" title=\"Clearance Budget Black Ballet Shoes WHILE STOCKS LAST!\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballet-shoes-black-leather_1.jpg\" width=\"135\" height=\"135\" alt=\"Clearance Budget Black Ballet Shoes WHILE STOCKS LAST!\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/stirrup-tan.html\" title=\"Shimmer Tights Tan Stirrup\">Shimmer Tights Tan Stirrup</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$11.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/stirrup-tan.html\" title=\"Shimmer Tights Tan Stirrup\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/t/stirrup_shimmer_tights_tan.png\" width=\"135\" height=\"135\" alt=\"Shimmer Tights Tan Stirrup\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/fleshpink.html\" title=\"NEW! Flesh Pink Footed Tights\">NEW! Flesh Pink Footed Tights</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$6.68</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/fleshpink.html\" title=\"NEW! Flesh Pink Footed Tights\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/f/l/flesh_pink_tights.jpg\" width=\"135\" height=\"135\" alt=\"NEW! Flesh Pink Footed Tights\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/liz-gregory-irish-dance-academy-pack-shoes-leotard-socks-skirt.html\" title=\"Liz Gregory Irish Dance Academy Pack: Shoes Leotard Socks &amp; Skirt \">Liz Gregory Irish Dance Academy Pack: Shoes Leotard Socks &amp; Skirt </a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$40.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/liz-gregory-irish-dance-academy-pack-shoes-leotard-socks-skirt.html\" title=\"Liz Gregory Irish Dance Academy Pack: Shoes Leotard Socks &amp; Skirt \">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/l/i/liz_gregory_irish_dance_academy_green_tutu_pack.jpg\" width=\"135\" height=\"135\" alt=\"Liz Gregory Irish Dance Academy Pack: Shoes Leotard Socks &amp; Skirt \" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/clearance-long-sleeve-lined-black-leotard.html\" title=\"CLEARANCE Long Sleeve Lined Black Leotard\">CLEARANCE Long Sleeve Lined Black Leotard</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$6.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/clearance-long-sleeve-lined-black-leotard.html\" title=\"CLEARANCE Long Sleeve Lined Black Leotard\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/l/black_long_sleeve_leotard.jpg\" width=\"135\" height=\"135\" alt=\"CLEARANCE Long Sleeve Lined Black Leotard\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/clearance-short-sleeve-lined-black-leotard.html\" title=\"CLEARANCE Short Sleeve Lined Black Leotard\">CLEARANCE Short Sleeve Lined Black Leotard</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$6.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/clearance-short-sleeve-lined-black-leotard.html\" title=\"CLEARANCE Short Sleeve Lined Black Leotard\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/l/black_short_sleeve_leotard_lined.jpg\" width=\"135\" height=\"135\" alt=\"CLEARANCE Short Sleeve Lined Black Leotard\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/clearance-short-sleeve-lined-black-leotard-7826.html\" title=\"CLEARANCE Tank Lined Black Leotard 2-3 years\">CLEARANCE Tank Lined Black Leotard 2-3 years</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$6.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/clearance-short-sleeve-lined-black-leotard-7826.html\" title=\"CLEARANCE Tank Lined Black Leotard 2-3 years\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/a/tank_black_leotard_lined.jpg\" width=\"135\" height=\"135\" alt=\"CLEARANCE Tank Lined Black Leotard 2-3 years\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/ballerina-gift-pack.html\" title=\"Ballerina Gift Pack\">Ballerina Gift Pack</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$35.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/ballerina-gift-pack.html\" title=\"Ballerina Gift Pack\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_ballerina_gift_set.png\" width=\"135\" height=\"135\" alt=\"Ballerina Gift Pack\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/microfiber-dance-socks-prima-pink-candy-pink-white.html\" title=\"Microfiber Dance Socks - Prima Pink, Candy Pink, White\">Microfiber Dance Socks - Prima Pink, Candy Pink, White</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$2.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/microfiber-dance-socks-prima-pink-candy-pink-white.html\" title=\"Microfiber Dance Socks - Prima Pink, Candy Pink, White\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/m/i/microfiber_socks_1.jpg\" width=\"135\" height=\"135\" alt=\"Microfiber Dance Socks - Prima Pink, Candy Pink, White\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-white-spring-clearance.html\" title=\"Romantic Tutu in White - SPRING CLEARANCE\">Romantic Tutu in White - SPRING CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$15.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-white-spring-clearance.html\" title=\"Romantic Tutu in White - SPRING CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/r/o/romantic_tutu_white_clearance.jpg\" width=\"135\" height=\"135\" alt=\"Romantic Tutu in White - SPRING CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-white-spring-clearance-7838.html\" title=\"Romantic Tutu in Aqua - SPRING CLEARANCE\">Romantic Tutu in Aqua - SPRING CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$15.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-white-spring-clearance-7838.html\" title=\"Romantic Tutu in Aqua - SPRING CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/r/o/romantic_tutu_aqua_clearance.jpg\" width=\"135\" height=\"135\" alt=\"Romantic Tutu in Aqua - SPRING CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/ballerina-stamp-set.html\" title=\"Ballerina Stamp Set\">Ballerina Stamp Set</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$7.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/ballerina-stamp-set.html\" title=\"Ballerina Stamp Set\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballerina_stzsamp_collection_2.jpg\" width=\"135\" height=\"135\" alt=\"Ballerina Stamp Set\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/ballerina-pen-7833.html\" title=\"Ballerina Pen\">Ballerina Pen</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$4.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/ballerina-pen-7833.html\" title=\"Ballerina Pen\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballerina-pen_1.jpg\" width=\"135\" height=\"135\" alt=\"Ballerina Pen\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/pink-tutu-handbag.html\" title=\"Pink Tutu Handbag\">Pink Tutu Handbag</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/pink-tutu-handbag.html\" title=\"Pink Tutu Handbag\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/u/tutu_bag1.jpg\" width=\"135\" height=\"135\" alt=\"Pink Tutu Handbag\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/white-convertible-tights-overstocked-sale-online-only.html\" title=\"White Convertible Tights Adult Sizes OVERSTOCKED SALE Online Only\">White Convertible Tights Adult Sizes OVERSTOCKED SALE Online Only</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$5.01</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/white-convertible-tights-overstocked-sale-online-only.html\" title=\"White Convertible Tights Adult Sizes OVERSTOCKED SALE Online Only\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/w/h/white_convertible_tights_clearance.jpg\" width=\"135\" height=\"135\" alt=\"White Convertible Tights Adult Sizes OVERSTOCKED SALE Online Only\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-pink-spring-clearance.html\" title=\"Romantic Tutu in Pink - SPRING CLEARANCE\">Romantic Tutu in Pink - SPRING CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$15.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-pink-spring-clearance.html\" title=\"Romantic Tutu in Pink - SPRING CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/r/o/romantic_tutu.jpg\" width=\"135\" height=\"135\" alt=\"Romantic Tutu in Pink - SPRING CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-children-s-glitter-singlet-top.html\" title=\"Studio Range Children's Glitter Singlet Top\">Studio Range Children's Glitter Singlet Top</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$22.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-children-s-glitter-singlet-top.html\" title=\"Studio Range Children's Glitter Singlet Top\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/c/h/chs03_aqua_crop_1.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range Children's Glitter Singlet Top\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/nylon-ballet-skirt-in-pale-pink.html\" title=\"Nylon Ballet Skirt in Pale Pink\">Nylon Ballet Skirt in Pale Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$2.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/nylon-ballet-skirt-in-pale-pink.html\" title=\"Nylon Ballet Skirt in Pale Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/k/skirt_crop.jpg\" width=\"135\" height=\"135\" alt=\"Nylon Ballet Skirt in Pale Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-tutu-new-colours.html\" title=\"Studio Range Tutu - New Colours!\">Studio Range Tutu - New Colours!</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$37.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-tutu-new-colours.html\" title=\"Studio Range Tutu - New Colours!\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/c/h/chtu01_hot_pink_large.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range Tutu - New Colours!\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-adults-tactel-camisole-leotard.html\" title=\"STUDIO RANGE Adults Tactel Camisole Leotard - 15 Colours\">STUDIO RANGE Adults Tactel Camisole Leotard - 15 Colours</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$32.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-adults-tactel-camisole-leotard.html\" title=\"STUDIO RANGE Adults Tactel Camisole Leotard - 15 Colours\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/a/tal02-bl-fr_hr.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE Adults Tactel Camisole Leotard - 15 Colours\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/crop-and-shorts-set.html\" title=\"Crop and Shorts Set\">Crop and Shorts Set</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/crop-and-shorts-set.html\" title=\"Crop and Shorts Set\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/o/top_and_shorts_pack.png\" width=\"135\" height=\"135\" alt=\"Crop and Shorts Set\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-adults-tactel-widestrap-leotard.html\" title=\"STUDIO RANGE Adults Tactel Wide Strap Leotard - 15 Colours\">STUDIO RANGE Adults Tactel Wide Strap Leotard - 15 Colours</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$32.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-adults-tactel-widestrap-leotard.html\" title=\"STUDIO RANGE Adults Tactel Wide Strap Leotard - 15 Colours\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/a/d/adults_wide_strap_leotard_1.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE Adults Tactel Wide Strap Leotard - 15 Colours\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"							<li class=\"featuredproductslider-item\">\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/leather-slip-on-jazz-bootie-black.html\" title=\"Leather Slip on Jazz Bootie - BLACK - CLEARANCE INTERNET ONLY\">Leather Slip on Jazz Bootie - BLACK - CLEARANCE INTERNET ONLY</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$19.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/leather-slip-on-jazz-bootie-black.html\" title=\"Leather Slip on Jazz Bootie - BLACK - CLEARANCE INTERNET ONLY\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/o/bootie_clearance2.jpg\" width=\"135\" height=\"135\" alt=\"Leather Slip on Jazz Bootie - BLACK - CLEARANCE INTERNET ONLY\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>\n" +
"						</ul>\n" +
"			<script type=\"text/javascript\">\n" +
"				$jq('.ma-featuredproductslider-container .flexslider').flexslider({\n" +
"					slideshow: false,					itemWidth: 195,\n" +
"					itemMargin: 20,\n" +
"					minItems: 2,\n" +
"					maxItems: 4,\n" +
"					slideshowSpeed: 3000,\n" +
"					animationSpeed: 600,\n" +
"					controlNav: false,										animation: \"slide\"\n" +
"				});\n" +
"			</script>\n" +
"		</div>\n" +
"		</div> \n" +
"\n" +
"<div class=\"banner-home\">\n" +
"<div class=\"row-fluid\">\n" +
"<div class=\"span6\">\n" +
"<div class=\"banner-box col\">\n" +
"<div class=\"row-fluid\">\n" +
"<div class=\"span3\">\n" +
"<div class=\"banner-image\">&nbsp;<a href=\"https://www.balletstuff.com.au/index.php/delivery/?___store=au\"><img alt=\"\" src=\"/media/wysiwyg/bg1-static-top.png\" /></a></div>\n" +
"</div>\n" +
"<div class=\"span9\">\n" +
"<h3>STANDARD SHIPPING</h3>\n" +
"<p><span style=\"font-size: 12px;\">From <span style=\"color: #ff558e;\">$7.95</span> Australia-wide<br />&nbsp;</span></p>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<div class=\"span6\">\n" +
"<div class=\"banner-box col2\">\n" +
"<div class=\"row-fluid\">\n" +
"<div class=\"span3\">\n" +
"<div class=\"banner-image\">&nbsp;<a href=\"https://www.balletstuff.com.au/index.php/delivery/?___store=au\"><img alt=\"\" src=\"/media/wysiwyg/bg1-static-top.png\" /></a></div>\n" +
"</div>\n" +
"<div class=\"span9\">\n" +
"<h3>EXPRESS POST</h3>\n" +
"<p><span style=\"font-size: 12px;\">Order by 2pm for next business day delivery&nbsp;</span><br /><span style=\"font-size: 12px;\">* For postcodes in Australia Post network</span></p>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"	<div class=\"ma-newproductslider-container\">\n" +
"			<div class=\"ma-newproductslider-title\"><h2>New Products</h2></div>\n" +
"			<div class=\"flexslider carousel\">\n" +
"			<ul class=\"slides\">\n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-tutu-new-colours.html\" title=\"Studio Range Tutu - New Colours!\">Studio Range Tutu - New Colours!</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$37.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-tutu-new-colours.html\" title=\"Studio Range Tutu - New Colours!\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/c/h/chtu01_hot_pink_large.jpg\" width=\"135\" height=\"135\" alt=\"Studio Range Tutu - New Colours!\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/nylon-ballet-skirt-in-pale-pink.html\" title=\"Nylon Ballet Skirt in Pale Pink\">Nylon Ballet Skirt in Pale Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$2.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/nylon-ballet-skirt-in-pale-pink.html\" title=\"Nylon Ballet Skirt in Pale Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/s/k/skirt_crop.jpg\" width=\"135\" height=\"135\" alt=\"Nylon Ballet Skirt in Pale Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-intermediate-dance-satchel-purple-trim.html\" title=\"Studio Intermediate Dance Satchel - Purple Trim\">Studio Intermediate Dance Satchel - Purple Trim</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$29.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-intermediate-dance-satchel-purple-trim.html\" title=\"Studio Intermediate Dance Satchel - Purple Trim\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/d/a/dance-satchels.jpg\" width=\"135\" height=\"135\" alt=\"Studio Intermediate Dance Satchel - Purple Trim\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/ballet-headband.html\" title=\"Ballet Headband - Black or Candy Pink\">Ballet Headband - Black or Candy Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$1.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/ballet-headband.html\" title=\"Ballet Headband - Black or Candy Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/ballet-headband---pink.jpg\" width=\"135\" height=\"135\" alt=\"Ballet Headband - Black or Candy Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-mulberry-pack-shoes-leotard-skirt-tights-7880.html\" title=\"STUDIO RANGE GATHERED FRONT TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights\">STUDIO RANGE GATHERED FRONT TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$69.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-mulberry-pack-shoes-leotard-skirt-tights-7880.html\" title=\"STUDIO RANGE GATHERED FRONT TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/p/a/pale_blue_tactel_pack_1.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE GATHERED FRONT TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-mulberry-pack-shoes-leotard-skirt-tights.html\" title=\"STUDIO RANGE MULBERRY PACK : Shoes, Leotard, Skirt &amp; Tights\">STUDIO RANGE MULBERRY PACK : Shoes, Leotard, Skirt &amp; Tights</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$69.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-mulberry-pack-shoes-leotard-skirt-tights.html\" title=\"STUDIO RANGE MULBERRY PACK : Shoes, Leotard, Skirt &amp; Tights\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/c/tcws01.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE MULBERRY PACK : Shoes, Leotard, Skirt &amp; Tights\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-mulberry-pack-shoes-leotard-skirt-tights-7879.html\" title=\"STUDIO RANGE PALE BLUE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights\">STUDIO RANGE PALE BLUE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$69.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-mulberry-pack-shoes-leotard-skirt-tights-7879.html\" title=\"STUDIO RANGE PALE BLUE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/p/a/pale_blue_tactel_pack.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE PALE BLUE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-works-shoes-leotard-tights-skirt-xover-headband.html\" title=\"STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)\">STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$75.56</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-works-shoes-leotard-tights-skirt-xover-headband.html\" title=\"STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff-studio-range-works1.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE WORKS : Shoes Leotard Tights Skirt Xover Headband  (11 Colours)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/studio-range-tactel-pack-shoes-leotard-skirt-tights.html\" title=\"STUDIO RANGE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights (13 Colours &amp; 2 leotard styles)\">STUDIO RANGE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights (13 Colours &amp; 2 leotard styles)</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$75.45</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/studio-range-tactel-pack-shoes-leotard-skirt-tights.html\" title=\"STUDIO RANGE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights (13 Colours &amp; 2 leotard styles)\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/t/c/tcws01_lil_large.jpg\" width=\"135\" height=\"135\" alt=\"STUDIO RANGE TACTEL PACK : Shoes, Leotard, Skirt &amp; Tights (13 Colours &amp; 2 leotard styles)\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/dance-duffel-bag.html\" title=\"Dance Drawstring Bag\">Dance Drawstring Bag</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$8.95</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/dance-duffel-bag.html\" title=\"Dance Drawstring Bag\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/bag-1.jpg\" width=\"135\" height=\"135\" alt=\"Dance Drawstring Bag\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/dance-exercise-band-pink.html\" title=\"Dance Exercise Band Pink\">Dance Exercise Band Pink</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$9.50</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/dance-exercise-band-pink.html\" title=\"Dance Exercise Band Pink\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/b/a/balletstuff_dance_resistance_band.jpg\" width=\"135\" height=\"135\" alt=\"Dance Exercise Band Pink\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"							<li>\n" +
"					<div class=\"item-inner\">\n" +
"						<div class=\"box-grid\">\n" +
"							<h2 class=\"product-name\"><a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-white-spring-clearance-7838.html\" title=\"Romantic Tutu in Aqua - SPRING CLEARANCE\">Romantic Tutu in Aqua - SPRING CLEARANCE</a></h2>\n" +
"							<div class=\"price-box\">\n" +
"								<span id=\"product-price-2988\" class=\"regular-price\">\n" +
"									<span class=\"price\">$15.00</span>\n" +
"								</span>\n" +
"							</div>\n" +
"						</div>\n" +
"						<a href=\"https://www.balletstuff.com.au/index.php/romantic-tutu-in-white-spring-clearance-7838.html\" title=\"Romantic Tutu in Aqua - SPRING CLEARANCE\">\n" +
"							<img class=\"product-image\" src=\"https://www.balletstuff.com.au/media/catalog/product/cache/1/small_image/135x135/9df78eab33525d08d6e5fb8d27136e95/r/o/romantic_tutu_aqua_clearance.jpg\" width=\"135\" height=\"135\" alt=\"Romantic Tutu in Aqua - SPRING CLEARANCE\" />\n" +
"						</a>\n" +
"					</div>\n" +
"				</li>                    \n" +
"						</ul>\n" +
"			<script type=\"text/javascript\">\n" +
"				$jq('.ma-newproductslider-container .flexslider').flexslider({\n" +
"					slideshow: false,					itemWidth: 197,\n" +
"					itemMargin: 20,\n" +
"					minItems: 2,\n" +
"					maxItems: 4,\n" +
"					slideshowSpeed: 3000,\n" +
"					animationSpeed: 600,\n" +
"					controlNav: false,										animation: \"slide\"\n" +
"				});\n" +
"			</script>\n" +
"		</div>\n" +
"	 \n" +
"	</div> \n" +
"</div></div>                            </div>\n" +
"                            \n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"          <div class=\"footer-brand-container\">\n" +
"    <div class=\"container\">\n" +
"        <div class=\"footer-brand\">\n" +
"            <div class=\"ma-brand-slider-contain\">\n" +
"                                    <div class=\"flexslider carousel\">			\n" +
"                        <ul class=\"slides\">\n" +
"				                                            <li class=\"item\">						    																																		    							            <a class=\"brand_item\" href=\"https://www.balletstuff.com.au/index.php/join-our-newsletter/\" title=\"Join Our Newsletter\"><img src=\"https://www.balletstuff.com.au/media/magentothem/brandslider/01-newsletter.jpg\" alt=\"\" /></a>                                                \n" +
"						            																																	             \n" +
"                                                                    </li>\n" +
"				                                            <li class=\"item\">						    																																		    							            <a class=\"brand_item\" href=\"https://www.balletstuff.com.au/index.php/factory-outlet-shop-sydney\" title=\"Sydney Shop Outlet\"><img src=\"https://www.balletstuff.com.au/media/magentothem/brandslider/02-factory.jpg\" alt=\"\" /></a>                                                \n" +
"						            																																	             \n" +
"                                                                    </li>\n" +
"				                                            <li class=\"item\">						    																																		    							            <a class=\"brand_item\" href=\"https://www.balletstuff.com.au/index.php/testimonial/\" title=\"Comments\"><img src=\"https://www.balletstuff.com.au/media/magentothem/brandslider/03-comments.jpg\" alt=\"\" /></a>                                                \n" +
"						            																																	             \n" +
"                                                                    </li>\n" +
"				                                            <li class=\"item\">						    																																		    							            <a class=\"brand_item\" href=\"https://www.balletstuff.com.au/index.php/shippinginfo\" title=\"Returns and  Exchanges\"><img src=\"https://www.balletstuff.com.au/media/magentothem/brandslider/04-returns.jpg\" alt=\"\" /></a>                                                \n" +
"						            																																	             \n" +
"                                                                    </li>\n" +
"				                                            <li class=\"item\">						    																																		    							            <a class=\"brand_item\" href=\"https://www.balletstuff.com.au/index.php/contacts/\" title=\"Contact Us\"><img src=\"https://www.balletstuff.com.au/media/magentothem/brandslider/05-contact.jpg\" alt=\"\" /></a>                                                \n" +
"						            																																	             \n" +
"                                                                    </li>\n" +
"				                                            <li class=\"item\">						    																																		    							            <a class=\"brand_item\" href=\"https://www.balletstuff.com.au/index.php/blog/\" title=\"Blog\"><img src=\"https://www.balletstuff.com.au/media/magentothem/brandslider/06-blog.jpg\" alt=\"\" /></a>                                                \n" +
"						            																																	             \n" +
"                                                                    </li>\n" +
"				                                    </ul>\n" +
"                        <script type=\"text/javascript\">\n" +
"                        //<![CDATA[\n" +
"					            $jq('.ma-brand-slider-contain .flexslider').flexslider({\n" +
"						            						            slideshow: false,\n" +
"						            						            itemWidth: 233,\n" +
"						            itemMargin: 0,\n" +
"						            minItems: 2,\n" +
"						            maxItems: 5,\n" +
"						            slideshowSpeed: 4000,\n" +
"						            animationSpeed: 600,\n" +
"						            						            controlNav: false,\n" +
"						            						            						            animation: \"slide\"\n" +
"					            });\n" +
"                        //]]>\n" +
"                        </script>\n" +
"                    </div>		\n" +
"            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"</div> <div class=\"footer-container\">\n" +
"    \n" +
"            <!-- ma-footer-static-top -->\n" +
"    \n" +
"    <!-- ma-footer-static-center -->\n" +
"    <div class=\"ma-footer-static-container\">\n" +
"        <div class=\"footer-static row-fluid\">\n" +
"            <div class=\"container\">\n" +
"                <div class=\"f-col f-col1 span3\">\n" +
"<div class=\"footer-static-title\">\n" +
"<h3>&nbsp;<span style=\"font-size: 1.17em;\">Information</span></h3>\n" +
"</div>\n" +
"<div class=\"footer-static-content\">\n" +
"<ul>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/customer-service/\">Customer Service</a></li>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/catalogsearch/advanced/\">Advanced Search</a></li>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/sales/order/history/\">Order Status</a></li>\n" +
"<li class=\"first\"><a href=\"https://www.balletstuff.com.au/index.php/size-guides\">Size Guides</a></li>\n" +
"<li class=\"last\"><a href=\"https://www.balletstuff.com.au/index.php/catalog/seo_sitemap/category/\">Sitemap</a></li>\n" +
"</ul>\n" +
"</div>\n" +
"</div>\n" +
"<div class=\"f-col f-col2 span3\">\n" +
"<div class=\"footer-static-title\">\n" +
"<h3>Shipping &amp; Returns</h3>\n" +
"</div>\n" +
"<div class=\"footer-static-content row-fluid\">\n" +
"<ul>\n" +
"<li class=\"first\"><a href=\"https://www.balletstuff.com.au/index.php/delivery/?___store=au\">Delivery</a></li>\n" +
"<li class=\"first\"><a href=\"https://www.balletstuff.com.au/index.php/shippinginfo/?___store=au\">Returns</a></li>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/secure-shopping/?___store=au\">Secure Shopping</a></li>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/customer/account/\">My Account</a></li>\n" +
"<li class=\"last\"><a href=\"https://www.balletstuff.com.au/index.php/contacts/\">Contact</a></li>\n" +
"</ul>\n" +
"</div>\n" +
"</div>\n" +
"<div class=\"f-col f-col3 span3\">\n" +
"<div class=\"footer-static-title\">\n" +
"<h3>My account</h3>\n" +
"</div>\n" +
"<div class=\"footer-static-content row-fluid\">\n" +
"<ul>\n" +
"<li class=\"first\"><a href=\"https://www.balletstuff.com.au/index.php/customer/account/login/\">Sign In</a></li>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/checkout/cart/\">View Cart</a></li>\n" +
"<li><a href=\"https://www.balletstuff.com.au/index.php/wishlist/\">My Wishlist</a></li>\n" +
"<li class=\"last\"><a href=\"https://www.balletstuff.com.au/index.php/help/?___store=au\">Help</a></li>\n" +
"</ul>\n" +
"<div><img alt=\"\" src=\"https://www.balletstuff.com.au/media/wysiwyg/payment_gateway.png\" /></div>\n" +
"</div>\n" +
"</div>\n" +
"<div class=\"f-col f-col4 span3\">\n" +
"<div class=\"about-us\">\n" +
"<div class=\"footer-static-title\">\n" +
"<h3>Facebook</h3>\n" +
"</div>\n" +
"<div class=\"footer-static-content row-fluid\"> <!-- start enable module -->\n" +
"	<div class=\"ma-likebox\">\n" +
"		<iframe src=\"//www.facebook.com/plugins/likebox.php?href=https://www.facebook.com/ballet.stuff&amp;width=245&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;height=270\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:245px;height:270px;\" allowTransparency=\"true\"></iframe>	</div>\n" +
"</div>\n" +
"</div>\n" +
"</div>            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"    \n" +
"    <div class=\"ma-footer-container\">\n" +
"        <div class=\"container\">\n" +
"            <div class=\"footer\">\n" +
"                <div class=\"row-fluid\">\n" +
"                    <div class=\"span6 f-address\">\n" +
"                        \n" +
"                        <address>Copyright © 2015 <a href=\"http://balletstuff.com.au/\">BalletStuff</a>. All rights reserved. eCommerce website by <a href=\"http://webcare.com.au\" target=\"_blank\">WebCare Solutions</a></address>\n" +
"                    </div>\n" +
"                    <div class=\"span6 f-store\">\n" +
"                        <img class=\"payment_footer\" style=\"\" src=\"https://www.balletstuff.com.au/skin/frontend/default/ma_miss_shop//images/payment.png\" alt=\"Payment\"/>\n" +
"                        \n" +
"                    </div>\n" +
"                </div>\n" +
"                <div id=\"back-top\" class=\"hidden-phone\">	</div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>        <div id =\"ajaxconfig_info\" style =\"display:none\">\n" +
"<a href =\"https://www.balletstuff.com.au/index.php/\"></a>\n" +
"<div ><img src =\"https://www.balletstuff.com.au/media/theme/default/ajax-loader_1.gif\" alt =\"Loading Image\" /></div>\n" +
"<button name =\"#000000\" value =\"0.7\" ></button>\n" +
"<input type=\"hidden\" value =\"\"/>\n" +
"<input type=\"hidden\" id=\"enable_module\" value =\"1\"/>\n" +
"<input class=\"effect_to_cart\" type=\"hidden\" value =\"1\"/>\n" +
"<input class=\"title_shopping_cart\" type=\"hidden\" value =\"Go to shopping cart\"/>\n" +
"<input class=\"title_shopping_continue\" type=\"hidden\" value =\"Continue Shopping\"/>\n" +
"<input class=\"title_shopping_wishlist\" type=\"hidden\" value =\"Go to wishlist\"/>\n" +
"<input class=\"title_shopping_compare\" type=\"hidden\" value =\"Go to list Compare\"/>\n" +
"<input class=\"confirm_delete_product\" type=\"hidden\" value =\"Are you sure you would like to remove this item ?\"/>\n" +
"<input class=\"title_add_to_cart\" type=\"hidden\" value =\"Add product to  Cart sucessfully\"/>\n" +
"<input class=\"title_add_to_wishlist\" type=\"hidden\" value =\"Add product to Wishlist sucessfully\"/>\n" +
"<input class=\"title_add_to_compare\" type=\"hidden\" value =\"Add product to Compare sucessfully\"/>\n" +
"<input class=\"using_ssl\" type=\"hidden\" value =\"0\"/>\n" +
"\n" +
"\n" +
"</div>\n" +
"<div id=\"ajaxcart-checkout-content\" style=\"display:none;\"></div>\n" +
"<div id =\"productHaveOption\"  style=\"display:block;\" ></div>    </div>\n" +
"</div>\n" +
"<!-- Google Code for Remarketing Tag -->\n" +
"<!--------------------------------------------------\n" +
"Remarketing tags may not be associated with personally identifiable information or placed on pages related to sensitive categories. See more information and instructions on how to setup the tag on: http://google.com/ads/remarketingsetup\n" +
"--------------------------------------------------->\n" +
"<script type=\"text/javascript\">\n" +
"/* <![CDATA[ */\n" +
"var google_conversion_id = 1040825846;\n" +
"var google_custom_params = window.google_tag_params;\n" +
"var google_remarketing_only = true;\n" +
"/* ]]> */\n" +
"</script>\n" +
"<script type=\"text/javascript\" src=\"//www.googleadservices.com/pagead/conversion.js\">\n" +
"</script>\n" +
"<noscript>\n" +
"<div style=\"display:inline;\">\n" +
"<img height=\"1\" width=\"1\" style=\"border-style:none;\" alt=\"\" src=\"//googleads.g.doubleclick.net/pagead/viewthroughconversion/1040825846/?guid=ON&amp;script=0\"/>\n" +
"</div>\n" +
"</noscript>\n" +
"</body>\n" +
"</html>";
        } else {
            pageContent = this.getPage(url);
        }

        if (pageContent != null) {

            System.out.println("Cleaning HTML tags...");
            String temp = pageContent
                    .replaceAll("</body>[\\w|\\W]+", "")
                    .split("<body\\b[^<]*>")[1]
                    .replaceAll("[\\s]*\\{.*?\\}", "")
                    .replaceAll("<script\\b[^<]*(?:(?!</script>)<[^<]*)*</script>", "")
                    .replaceAll("<[^>]*>", "")
                    .replaceAll("\n", " ")
                    .replaceAll("  ", " ")
                    .replaceAll("[0-9]", "")
                    .replaceAll("[\\s]+", "0")
                    .replaceAll("\\W", "");

            for (String string : temp.split("0")) {
                String s = string.toLowerCase();
                if (s.length() > 2) {
                    result.add(s);
                }
            }
            return result;
        }
        return null;
    }
}
