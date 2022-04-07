<#import "parts/common.ftlh" as c>
<#import "parts/pager.ftlh" as p>

<@c.page>
    <@p.pager url news />
    <div class="container mt-5">

            <div class="container mt-5">
                <#list news.content as n>
                    <div class="container mt-3">
                        <b>${n.header}</b>
                        <span>${n.body}</span>
                    </div>
                <#else>
                    <span>Новостей нет</span>
                </#list>
            </div>

    </div>
</@c.page>