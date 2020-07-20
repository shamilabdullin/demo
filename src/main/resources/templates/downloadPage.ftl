<#import "lib/html.ftl" as H>

<@H.html>
    <@H.head "Link">
    </@H.head>
    <@H.body>
        <div id="parent">
            <div id="child">
                <form method="get" action="/download/${link}">
                    <h1>${fileName}<br></h1>
                    <input type="submit" value="Скачать">
                </form>
            </div>
        </div>
    </@H.body>
</@H.html>