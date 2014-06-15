<html><head><META http-equiv="Content-Type" content="text/html; charset=utf-8"></head><body>
<div>
<div><a href="http://posts/new" target="_blank">New Post</a></div>
<h2>Posts:</h2>
<ul>
<#list posts as post>
  <li><a href="http:/localhost:8080/posts/${post.id}" target="_blank">${post.title}</a></li>
</#list>
</ul>
</div>
</body></html>