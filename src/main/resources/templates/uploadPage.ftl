<#import "lib/html.ftl" as H>

<@H.html>
    <@H.head "Link">
    </@H.head>
    <@H.body>
        <div id="parent">
            <div id="child">
                <form method="post" action="/upload" enctype="multipart/form-data">
                    <p><input type="file" id="file" name="file">
                        <input type="submit" value="Save file to storage">
                </form>
            </div>
        </div>
    </@H.body>
</@H.html>