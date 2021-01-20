<%--
  Created by IntelliJ IDEA.
  User: XiR
  Date: 1/20/2021
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>

<script>
    var service = 'http://localhost:8080/horse'

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });
    };

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });
    };

    var RestPost = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description
        };

        $.ajax({
            type: 'POST',
            url: service + '/add',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });
    };

    var RestPut = function (id, name, description) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description
        };

        $.ajax({
            type: 'PUT',
            url: service + '/update',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });
    };

</script>

<body>
<h1>Horse API</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get all horses - <code><strong>GET</strong></code></td>
        <td>/horse/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">try</button>
        </td>
    </tr>
    <tr>
        <td>Get horse by id - <code><strong>GET</strong></code></td>
        <td>/horse/get/{id}</td>
        <td>
            id: <input id="getHorseByID" value="1"/>
            <button type="button" onclick="RestGet($('#getHorseByID').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Add new horse - <code><strong>POST</strong></code></td>
        <td>/horse/add</td>
        <td>
            name: <input id="horseName" value="Risak"/>
            description: <input id="horseDescription" value="fast"/>
            <button type="button" onclick="RestPost($('#horseName').val(), $('#horseDescription').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Update horse - <code><strong>PUT</strong></code></td>
        <td>/horse/update</td>
        <td>
            id: <input id="horseID" value=1>
            name: <input id="horseNameForUpdate" value="Risak"/>
            description: <input id="horseDescriptionForUpdate" value="fast"/>
            <button type="button" onclick="RestPut($('#horseID').val(), $('#horseNameForUpdate').val(),
             $('#horseDescriptionForUpdate').val())">try</button>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="page-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>

</body>
</html>