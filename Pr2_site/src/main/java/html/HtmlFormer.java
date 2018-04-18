package html;

import entity.Item;
import entity.User;
import java.util.List;

public class HtmlFormer {

    public static String top(String title, User u) {
        String out = "<html>\n"
                + "    <head>\n"
                + "        <title>BMW Motors " + title + "</title>\n"
                + "        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div id='header' align='center' style='height: 45px; background-color: aquamarine; align-content: center'>\n"
                + "            <table>\n"
                + "                <tr>\n"
                + "                    <td>"
                + "                        <a href='/Pr2_site/main'><h1>BMW Motors Ukraine</h1></a>\n"
                + "                    </td>\n"
                + "                    <td>";
        if (u == null) {
            out += "                        <form action='/Pr2_site/login'>\n"
                    + "                            <input type='submit' value='Sign In'/>\n"
                    + "                        </form>\n";
        } else {
            out += "                        <form action='/Pr2_site/profile'>\n"
                    + "                            <input type='submit' value='My Profile'/>\n"
                    + "                        </form></td>\n"
                    + "                        <td><form action='/Pr2_site/basket'>\n"
                    + "                            <input type='submit' value='Basket'/>\n"
                    + "                        </form></td>\n"
                    + "                        <td><a href='/Pr2_site/main?exit=true'>\n"
                    + "                            <input type='submit' value='Exit'/>\n"
                    + "                        </a>\n";
        }
        out += "                    </td>\n"
                + "                </tr>\n"
                + "            </table>"
                + "        </div>\n"
                + "        <div id='search' align='center' style='height: 25px; background-color: coral; align-content: center'>\n"
                + "            <form action='/Pr2_site/main'>\n"
                + "                Search:<input name='q'/>\n"
                + "                <input type='submit' value='Search'/>\n"
                + "            </form>\n"
                + "        </div>\n"
                + "        <div id='menu' align='center' style='height: 50px; background-color: violet; align-content: center'>\n"
                + "            <table>\n"
                + "                <tr>\n"
                + "                    <td width='200px'>\n"
                + "                        <h1><a href='/Pr2_site/main?cat=c'>Car</a></h1>\n"
                + "                    </td>\n"
                + "                    <td width='200px'>\n"
                + "                        <h1><a href='/Pr2_site/main?cat=s'>SUW</a></h1>\n"
                + "                    </td>\n"
                + "                    <td width='200px'>\n"
                + "                        <h1><a href='/Pr2_site/main?cat=e'>Electro</a></h1>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </table>\n"
                + "        </div>\n"
                + "        <div id='content' align='center' style='background-color: antiquewhite; align-content: center'>";
        return out;
    }

    public static String end() {
        return "        </div>\n"
                + "        <div id='footer' align='center' style='height: 15px; background-color: darkgoldenrod; align-content: center'>\n"
                + "            <h6>Copyright Alex</h6>\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>";
    }

    public static String contentMain(String top, String end, List<Item> items) {
        String out = top;
        for (Item i : items) {
            out += "            <a href='/Pr2_site/item?id=" + i.getId() + "'><div style='height: 100px'>\n"
                    + "                <table>\n"
                    + "                    <tr>\n"
                    + "                        <td>\n"
                    + "                            <h1>" + i.getModel() + "</h1>\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            <img style='height: 100px' src='" + i.getPic() + "'/>\n"
                    + "                        </td>\n"
                    + "                        <td style='width: 400px'>\n"
                    + "                            <h3>" + i.getAbout() + "</h3>\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            <h1>" + i.getPrice() + " UAH</h1>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                </table>\n"
                    + "            </div></a><hr/>";
        }
        out += end;
        return out;
    }

    public static String contentItem(String top, String end, Item item, User u) {
        String out = top
                + "            <div>\n"
                + "                <table>\n"
                + "                    <tr>\n"
                + "                        <td>\n"
                + "                            <h1>" + item.getModel() + "</h1>"
                + "                            <img style='height: 500px' src='" + item.getPic() + "'/>"
                + "                            <h1>" + item.getPrice()
                + " UAH</h1> \n";
        if (u != null) {
            out += "<a href='/Pr2_site/basket?id=" + item.getId() + "'><input type='submit'value='Add to basket'/></a> \n";
        }
        out += "                        </td>\n"
                + "                        <td style='width: 400px'>\n"
                + "                            <h3>" + item.getAbout() + "</h3>\n"
                + "                        </td>\n"
                + "                    </tr>\n"
                + "                </table>\n"
                + "            </div><hr/>"
                + end;
        return out;
    }

    public static String contentLogin(String top, String end) {
        String out = top
                + "            <h1>Sign In Page</h1>\n"
                + "            <form action='/Pr2_site/login' method='POST'>\n"
                + "                Input login:<input name='login'/><br/>\n"
                + "                Input pass: <input type='password' name='pass'/><br/>\n"
                + "                <input type='submit' value='Sign In'/>\n"
                + "            </form>\n"
                + "            <form action='/Pr2_site/register'>\n"
                + "                <input type='submit' value='Register'/>\n"
                + "            </form>"
                + end;
        return out;
    }

    public static String contentRegister(String top, String end) {
        String out = top
                + "            <h1>Register Page</h1>\n"
                + "            <form action='/Pr2_site/register' method='POST'>\n"
                + "                Input login:<input name='login'/><br/>\n"
                + "                Input password: <input type='password' name='pass1'/><br/>\n"
                + "                Input pass again: <input type='password' name='pass2'/><br/>\n"
                + "                <input type='submit' value='Register'/>\n"
                + "            </form>\n"
                + end;
        return out;
    }

    public static String contentBasket(String top, String end, List<Item> items) {
        String out = top;
        out += "<a href='/Pr2_site/basket?id=0'>"
                + "<input type='submit' value='Clear Basket'/>"
                + "</a>";
        out += "<h1>Your Basket:</h1>";
        for (Item i : items) {
            out += "            <a href='/Pr2_site/item?id=" + i.getId() + "'><div style='height: 100px'>\n"
                    + "                <table>\n"
                    + "                    <tr>\n"
                    + "                        <td>\n"
                    + "                            <h1>" + i.getModel() + "</h1>\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            <img style='height: 100px' src='" + i.getPic() + "'/>\n"
                    + "                        </td>\n"
                    + "                        <td style='width: 400px'>\n"
                    + "                            <h3>" + i.getAbout() + "</h3>\n"
                    + "                        </td>\n"
                    + "                        <td>\n"
                    + "                            <h1>" + i.getPrice() + " UAH</h1><a href='/Pr2_site/basket?id=-" + i.getId() + "'><input type='submit'value='Remove from basket'/></a>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                </table>\n"
                    + "            </div></a><hr/>";
        }
        out += end;
        return out;
    }
}
