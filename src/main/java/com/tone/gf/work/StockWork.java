package com.tone.gf.work;

import com.teamdev.jxbrowser.chromium.dom.By;
import com.teamdev.jxbrowser.chromium.dom.DOMElement;
import com.tone.gf.AppInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取每个股对应的页面对象线程
 */
public class StockWork implements Runnable {
    @Override
    public void run() {
        DOMElement domElementGrid = AppInfo.DOCUMENT.findElement(By.className("StockList StockGrid ScrollbarOuter"));
        DOMElement domElementData = domElementGrid.findElement(By.className("TbodyInner"));
//        DOMElement domElementBrief = domElementData.findElement(By.className("brief"));
//        List<DOMElement> briefs = domElementBrief.findElements(By.tagName("tr"));
//        briefs.stream().forEach(brief -> {
//            System.out.println(brief.getInnerHTML());
//        });
        DOMElement domElementDetail = domElementData.findElement(By.className("detailOuter"));
        List<DOMElement> details = domElementDetail.findElements(By.tagName("tr"));
        AppInfo.STOCK_DOCUMENT = details.stream().collect(Collectors.toMap(detail -> detail.getAttribute("data-key").substring(3), detail -> detail));
    }
}
