<#import "parts/common.ftl" as c>
<#if user??><#assign login = true></#if>
<@c.page login!false user!false>

<body>

<div class="container  ">
 <div class="container d-flex flex-column  align-items-start  mb-5">
  <div class="row">
    <div class="col-sm">
       <h3 class="display-4 ">${userpage.username} styles</h3>
    </div>
  </div>
</div>
  <div class="row">
      <#list tShirts as tShirt>
            <div class="col-4">
              <div  class=" col d-flex flex-column  align-items-center  border-bottom shadow-sm border size hover" >
                  <a href="/TShirts/${tShirt.id}">
                <img class="d-block w-100" src="${tShirt.urlShirt}" style="width: 285px;height: 274px;">
                   </a>
                  <h5>18$</h5>
                  <button class="btn btn-outline-primary margin" type="button">Buy</button>
              </div>
            </div>
      </#list>

      <div class="col-4 hover ">
          <div class=" col d-flex flex-column align-items-center size" style="margin-top: 35%;">
              <a href="/TShirts/add?username=${userpage.username}">
                  <img class="rounded d-block w-100" src="/style/plus.jpg">
              </a>
          </div>
      </div>
  </div>
</div>
  </@c.page>
