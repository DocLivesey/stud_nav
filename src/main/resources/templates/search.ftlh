<#import "parts/common.ftlh" as c>
<#import "parts/pager.ftlh" as p>

<@c.page>
    <div class="container mt-5">


        <form method="get" action="/show_course" class="form-inline">
            <div class="input-group mb-3 mt-3">
                <#--        <div class="form-group col-md-6">-->

                <input type="text" class="form-control" placeholder="Поиск по специальности" name="filter"
                       aria-describedby="button-addon2" value="${filter?ifExists}"
                       placeholder="Поиск по перметов по спецальности">
                <button type="submit" class="btn btn-outline-secondary" id="button-addon2">Search</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <#--        </div>-->
            </div>
        </form>

        <div class="container mt-5">
            Для вашей специальности <b>${filter}</b> доступны направления:
        </div>
        <div class="container mt-5">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Направление</th>
                    <th scope="col">Форма обучения</th>
                    <th scope="col">Срок обучения</th>
                </tr>
                </thead>
                <tbody>
                <#list courses as course>
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.learningForm}</td>
                    <td>${course.semesters}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@c.page>