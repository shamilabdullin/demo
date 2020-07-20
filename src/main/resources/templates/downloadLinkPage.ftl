<#import "lib/html.ftl" as H>

<@H.html>
    <@H.head "Link">
    </@H.head>
    <@H.body>
        <div id="parent">
            <div id="child">
                <a href=${link}>${link}</a>
            </div>
        </div>
    </@H.body>
</@H.html>