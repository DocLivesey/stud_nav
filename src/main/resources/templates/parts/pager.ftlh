<#macro pager url page>
    <#if page.getTotalPages() gt 7>
        <#assign
        total = page.getTotalPages()
        pageNum = page.getNumber() + 1

        head = (pageNum > 4)?then([1, -1], [1, 2, 3])
        tail = (pageNum < total - 3)?then([-1, total], [total - 2, total - 1, total])
        before = (pageNum > 4 && pageNum < total - 1)?then([pageNum - 2, pageNum - 1], [])
        after = (pageNum > 2 && pageNum < total - 3)?then([pageNum + 1, pageNum + 2], [])

        body = head + before + (pageNum > 3 && pageNum < total - 2)?then([pageNum], []) + after + tail
        >
    <#else>
        <#assign body = 1..page.getTotalPages()>
    </#if>
    <div class="mt-3">
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Страницы</a>
            </li>
            <#list body as p>
                <#if (p - 1) == page.getNumber()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${p}</a>
                    </li>
                <#elseif p == -1>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">...</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>
</#macro>