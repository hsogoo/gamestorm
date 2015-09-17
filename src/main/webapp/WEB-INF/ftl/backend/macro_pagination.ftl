<#macro pagination totalPage="1" currentPage="1" function="">
    <#assign startPage = 0 />
    <#assign endPage = 0 />
    <#assign sideNum = 2 />
    <#assign totalPage = totalPage?number />
    <#assign currentPage = currentPage?number />

    <#if totalPage lte sideNum >
    	<#assign endPage = totalPage >
    <#else>
        <#if (sideNum+currentPage) gte totalPage >
            <#assign endPage = totalPage >
        <#else>
        	<#assign endPage = sideNum + currentPage >
            <#if (sideNum + currentPage) lte (2*sideNum+1)>
                <#if (2*sideNum+1) gte totalPage >
                    <#assign endPage = totalPage >
                <#else>
                	<#assign endPage = 2*sideNum+1 >
                </#if>
            <#else>
            	<#assign endPage = sideNum + currentPage >
            </#if>
        </#if>
    </#if>

    <#if currentPage lte sideNum >
        <#assign startPage = 1>
    <#else>
        <#if (currentPage+sideNum) gte totalPage >
            <#if (2*sideNum+1) gte totalPage>
                <#if (totalPage - 2*sideNum) gte 1 >
                    <#assign startPage = totalPage - 2*sideNum >
                <#else>
                    <#assign startPage = 1>
                </#if>
            <#else>
                <#assign startPage = totalPage - 2*sideNum >
            </#if>
        <#else>
            <#if (currentPage-sideNum) gte 1 >
                <#assign startPage = currentPage - sideNum>
            <#else>
                <#assign startPage = 1>
            </#if>
        </#if>
    </#if>

	<ul class="pagination">
		<#if startPage gt 1>
			<li><a href="javascript:void(0);" onclick="${function}(${startPage-1})">Prev</a></li>
		<#else>
			<li class="disabled"><a href="javascript:void(0);" onclick="${function}(1)">Prev</a></li>
		</#if>
		<#list startPage..endPage as i>
		  <li <#if currentPage?number == i>class="active"</#if>><a href="javascript:void(0);" onclick="${function}(${i})">${i}</a></li>
	 	</#list>
	 	<#if endPage lt totalPage>
			<li><a href="javascript:void(0);" onclick="${function}(${endPage+1})">Prev</a></li>
		<#else>
			<li class="disabled"><a href="javascript:void(0);" onclick="${function}(${totalPage})">Prev</a></li>
		</#if>
	</ul>
</#macro>
