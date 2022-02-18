<#import "parts/common.ftlh" as c>

<@c.page>
    <div>User List</div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/admin/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>


        <div class="form-group mt-3">
            <form method="post" action="/admin/news" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="header" placeholder="Заголовок новости" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="body" placeholder="Тело нвости">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>

</@c.page>

