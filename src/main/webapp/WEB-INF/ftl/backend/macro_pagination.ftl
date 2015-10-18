<#macro pagination totalPage="1" currentPage="1" function="">
    <#assign startPage = 0 />
    <#assign endPage = 0 />
    <#assign sideNum = 2 />

	<#if totalPage?number lte sideNum >
    	<#assign endPage = totalPage?number >
    <#else>
        <#if (sideNum+currentPage?number) gte totalPage?number >
            <#assign endPage = totalPage?number >
        <#else>
        	<#assign endPage = sideNum + currentPage?number >
            <#if (sideNum + currentPage?number) lte (2*sideNum+1)>
                <#if (2*sideNum+1) gte totalPage?number >
                    <#assign endPage = totalPage?number >
                <#else>
                	<#assign endPage = (2*sideNum+1) >
                </#if>
            <#else>
            	<#assign endPage = sideNum + currentPage?number >
            </#if>
        </#if>
    </#if>

    <#if currentPage?number lte sideNum >
        <#assign startPage = 1>
    <#else>
        <#if (currentPage?number+sideNum) gte totalPage?number >
            <#if (2*sideNum+1) gte totalPage?number>
                <#if (totalPage?number - 2*sideNum) gte 1 >
                    <#assign startPage = totalPage?number - 2*sideNum >
                <#else>
                    <#assign startPage = 1>
                </#if>
            <#else>
                <#assign startPage = totalPage?number - 2*sideNum >
            </#if>
        <#else>
            <#if (currentPage?number-sideNum) gte 1 >
                <#assign startPage = currentPage?number - sideNum>
            <#else>
                <#assign startPage = 1>
            </#if>
        </#if>
    </#if>

	<ul class="pagination pull-right">
		<#if startPage gt 1>
			<li><a href="javascript:void(0);" onclick="${function}(${startPage-1})">Prev</a></li>
		<#else>
			<li class="disabled"><a href="javascript:void(0);" onclick="${function}(1)">Prev</a></li>
		</#if>
		<#list startPage..endPage as i>
		  <li <#if currentPage?number == i>class="active"</#if>><a href="javascript:void(0);" onclick="${function}(${i})">${i}</a></li>
	 	</#list>
	 	<#if endPage lt totalPage?number>
			<li><a href="javascript:void(0);" onclick="${function}(${endPage+1})">Next</a></li>
		<#else>
			<li class="disabled"><a href="javascript:void(0);" onclick="${function}(${totalPage})">Next</a></li>
		</#if>
	</ul>
	
</#macro>
