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