package com.oceanier.action;

import com.oceanier.entity.Merchant;
import com.oceanier.service.MerchantService;
import com.oceanier.vo.merchant.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("merchantAction")
public class MerchantAction {

    @Autowired
    MerchantService merchantService;

    @RequestMapping("toAdd")
    public String toAdd(){
        return "merchant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Merchant merchant){
        merchantService.insertMerchant(merchant);
        System.out.println(merchant);
        return "redirect:queryByVo";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request, int id){
        Merchant merchant = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchant);
        return "merchant/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Merchant merchant){
        merchantService.updateMerchant(merchant);
        System.out.println(merchant);
        return "redirect:queryByVo";
    }

    @RequestMapping("delete")
    public String delete(int id){
        merchantService.deleteMerchantById(id);
        return "redirect:queryByVo";
    }

    @RequestMapping("query")
    public String queryMerchantById(HttpServletRequest request, int id){
        Merchant merchant = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchant);
        return "merchant/view";
    }

    @RequestMapping("queryByVo")
    public String queryMerchantByVo(HttpServletRequest request, MerchantVo merchantVo){
        List<Merchant> list = merchantService.queryMerchantByVo(merchantVo);
        request.setAttribute("merchantList", list);
        return "merchant/list";
    }
}
