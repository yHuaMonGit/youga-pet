var phoneNumberInputID = "phoneNumInput";
var vericodeInputID = "vericodeInput";

function getmemberInfo(userinfo,name)
{
    if(name == "level")
    {
        level =  userinfo[0].level;
        var p = document.getElementById(name);
        p.innerHTML = level;
    }else if(name == "integral")
    {
        integral =  userinfo[0].integral;
        var p = document.getElementById(name);
        p.innerHTML = integral+"��";
    }else if(name == "balance")
    {
        balance =  userinfo[0].balance;
        var p = document.getElementById(name);
        p.innerHTML = balance+"Ԫ";
    }else{
        return null;
    }
}

function getIcon(obj,userInfo)
{
    var parent = document.getElementById(obj);
    var div_icon=document.createElement("div");
    if(userInfo == null || userInfo.length<1 )
    {
        return 0;
    }
    var iconUrl = userInfo[0].headIconUrl;

    div_icon.setAttribute("class","touxiang");
    addImg(div_icon,iconUrl);
    parent.appendChild(div_icon);
}

function getName(obj,userInfo)
{
    var parent = document.getElementById(obj);
    var div_userName=document.createElement("div");
    if(userInfo == null || userInfo.length<1 )
    {
        return 0;
    }
    var userName = userInfo[0].userName;
    div_userName.setAttribute("class","name");
    div_userName.innerHTML = userName;
    parent.appendChild(div_userName);
}


function addImg(div,text){
    var img_1=document.createElement("img");
    img_1.src=text;
    div.appendChild(img_1);
}

function memberRegister(div, userInfo) {
    var parent = document.getElementById(div);
    var header = document.getElementById("vipHead");
    var van = document.getElementById("vipSpan");
    var ul = document.getElementById("vipUl");
    var memberFlag = userInfo[0].isMember;
    var openid = userInfo[0].openid;

    if ( memberFlag == 1)
    {
        bindingPhone(parent,openid);
        header.style.display = "none";
        van.style.display = "none";
        ul.style.display = "none";
    }
    else if (memberFlag == 0)
    {

    }
    else{

    }

}
var bindingParent;
function bindingPhone(div,openid) {

    var bindingParent = div;
    var binding_div=document.createElement("div");

    //test
    addPhoneNumDiv(binding_div,openid);
    //�����ֻ��������

    //������֤�����
    addVerifyDiv(binding_div);
    //����ύ��ť
    addSubmitDiv(binding_div,openid);

    //����˵�����
    binding_div.setAttribute("class","bindingPhone");
    binding_div.setAttribute("id","bindingPhone");
    bindingParent.appendChild(binding_div);
}

function addSubmitDiv(obj,openid)
{
    var parent = obj;
    var submit_div=document.createElement("div");
    submit_div.setAttribute("class","submitDiv");
    addSubmitButton(submit_div,openid);
    parent.appendChild(submit_div);
}

function addPhoneNumDiv(obj,openid)
{
    var parent = obj;
    var phoneNum_div=document.createElement("div");
    phoneNum_div.setAttribute("class","phoneTips");
    addText(phoneNum_div,"phoneNumInput",phoneNumberInputID,"�����ֻ�����");
    addButton(phoneNum_div,"phoneNumVerify","��ȡ��֤��",openid);
    parent.appendChild(phoneNum_div);
}

function addVerifyDiv(obj)
{
    var parent = obj;
    var phoneNum_div=document.createElement("div");
    phoneNum_div.setAttribute("class","verifyDiv");
    addText(phoneNum_div,"verifyInput",vericodeInputID,"������λ��֤��");
    parent.appendChild(phoneNum_div);
}


var wait=60;
function addButton(obj,classname,text,openid){
    var span_1=document.createElement("button");
    var verifyUrl = "../verify/getVerify"
    span_1.setAttribute("class",classname);
    span_1.innerHTML=text;
    obj.appendChild(span_1);
    span_1.addEventListener('click',function (ev) {
        var phoneInput = document.getElementById(phoneNumberInputID);
        phoneNumber = phoneInput.value;

        if(!isPoneAvailable(phoneNumber))
        {
            alert("����д��ȷ���ֻ����롣");
            return;
        }
        $.post(
            verifyUrl,
            {
                openid:openid,
                msisdn:phoneNumber
            },
            function(callbackdata){
                if( "121000"==callbackdata)
                {
                    alert("��֤���ѷ��ͣ������ֻ��ϲ鿴������֤�롣");
                }
            }
        )

        time(span_1);
    });

}

function addSubmitButton(obj,openid){
    var span_1=document.createElement("button");
    var verifyUrl = "../verify/checkVerify"
    var reopenurl = "../member/auth"

    span_1.setAttribute("class","verifySubmit");
    span_1.innerHTML="��֤�����ֻ�";
    obj.appendChild(span_1);
    span_1.addEventListener('click',function (ev) {

        var phoneInput = document.getElementById(phoneNumberInputID);
        var vericodeInput = document.getElementById(vericodeInputID);
        phoneNumber = phoneInput.value;
        vericode = vericodeInput.value;

        if("" == phoneNumber)
        {
            alert("�ֻ��Ż���Ҫ��Ĺ�~");
            return;
        }

        if(!isPoneAvailable(phoneNumber))
        {
            alert("��������ȷ���ֻ�����~");
            return;
        }
        if("" == vericode)
        {
            alert("��֤�벻��Ϊ�չ�~");
        }
        $.post(
            verifyUrl,
            {
                openid:openid,
                msisdn:phoneNumber,
                vericode:vericode
            },
            function(callbackdata)
            {
                if("000001" == callbackdata)
                {
                    alert("�󶨳ɹ���");
                    window.location.href=reopenurl;
                }
            }
        );
    });

}

function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(str)) {
        return false;
    } else {
        return true;
    }
}


function time(obj) {
    if (wait == 0) {
        obj.removeAttribute("disabled");
        obj.innerHTML="���·���";
        wait = 60;
    } else {

        obj.setAttribute("disabled", true);
        obj.innerHTML="���·���(" + wait + ")";
        wait--;
        setTimeout(function() {
                time(obj)
            },
            1000)
    }
}



function addSpan(obj,classname,text){
    var span_1=document.createElement("span");
    span_1.setAttribute("class",classname);
    span_1.innerHTML=text;
    obj.appendChild(span_1);
}

function addText(obj,classname,id,value){
    var span_1=document.createElement("input");
    span_1.setAttribute("class",classname);
    span_1.setAttribute("id",id);
    span_1.setAttribute("placeholder",value);
    obj.appendChild(span_1);

}