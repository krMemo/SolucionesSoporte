(function () {

    
    showLoadingIndicator = function () {    

            adf.mf.api.amx.showLoadingIndicator();
            
            clearTimeout(adf.mf.internal.amx._failSafeTimer);
            adf.mf.internal.amx._failSafeTimer=
                window.setTimeout(adf.mf.internal.amx.killLoadingIndicator,1E9);

    };
    
    
    calculatePopupPosition = function()
    {
        var topPosition = 0;
        var leftPosition = 0;
        var width = 0;
        var height = 0;
        var panelObj = null;
        var componentObj = null;
        var paramCount = arguments.length;
        
        switch (paramCount)
        {
            case 4:
                width = parseInt(arguments[3]);
            case 3:
                height = parseInt(arguments[2]);
            case 2:
                panelObj = document.getElementById(arguments[1]);
            case 1:
                componentObj = document.getElementById(arguments[0]);
            default:
        }

        if (panelObj)
        {
            // Get height of page header.
            var pageHeaderHeight = 0;
            var panelChildren = panelObj.children;
            var headerFound = false;
            for (var i = 0; (i < panelChildren.length && !headerFound); i++)
            {
                var styleClassList = panelChildren[i].attributes["class"].value;
                if (styleClassList.indexOf("amx-panelPage-header") != -1)
                {
                    headerFound = true;
                    pageHeaderHeight = panelChildren[i].offsetHeight;
                }
            }
            
            // Calculate initial top position by dividing page height by 3.
            var minTopPosition = -1 * pageHeaderHeight;
            var pageHeight = panelObj.offsetHeight;
            var actualContentHeight = pageHeight - pageHeaderHeight;
            topPosition = Math.round((pageHeight / 3) - pageHeaderHeight);

            if (height > 0)
            {
                // If popup height is specified, determine if top position needs to be reduced.
                if (height > pageHeight)
                {
                    // Position popup at top of page header.
                    topPosition = minTopPosition;
                }
                else
                {
                    // Also subtract popup padding (20px) and border (2px) from available height to center popup vertically.
                    var actualTopPos = Math.round(((actualContentHeight - height - 22) / 2) - (pageHeaderHeight / 2));
                    if (actualTopPos < topPosition)
                    {
                        if (actualTopPos < minTopPosition)
                        {
                            topPosition = minTopPosition;
                        }
                        else
                        {
                            topPosition = actualTopPos;
                        }
                    }
                }
            }
        
            if (width > 0)
            {
                // If popup width is specified, reduce available page width by popup width, padding (20px), and 
                // border (2px) before dividing by two.
                leftPosition = Math.round((panelObj.offsetWidth - width - 22) / 2);
            }
            else
            {
                if (componentObj)
                {
                    var paddingOffset = 0;
                    styleClassList = componentObj.attributes["class"].value;
                    if (styleClassList.indexOf("amx-outputText") != -1)
                    {
                        // Eighteen pixels are added to the total due to the difference between the extra
                        // padding on the output text field (38px) and the padding & border in the popup (22px).
                        paddingOffset = 16;
                    }
                    else if (styleClassList.indexOf("amx-commandLink") != -1)
                    {
                        // Twenty-two pixels are subtracted from the total due to popup padding (20px) and border (2px).
                        paddingOffset = -22;
                    }
                    
                    // Calculate left position by subtracting the message length from the page width and 
                    // dividing by two.  
                    leftPosition = Math.round((panelObj.offsetWidth - componentObj.offsetWidth + paddingOffset) / 2);
                }
                else
                {
                    leftPosition = Math.round(panelObj.offsetWidth / 3);
                }
            }
        
            if (leftPosition < 0)
            {
                leftPosition = 0;
            }
        }
        else
        {
            // Assign default top position to top of page content (below page header).
            topPosition = 0;
        }

        // Return position values as "TOP|LEFT" since return type is String on Android.
        var positionValues = topPosition + "|" + leftPosition;
        return positionValues;
    }


    pushPageButton = function()
    {
        if (arguments.length == 1)
        {
            var element = document.getElementById(arguments[0]);
            if (element)
            {
                executeCustomEvent(element, "touchstart");
                executeCustomEvent(element, "touchend");
            }
        }
    }
    
    
    function executeCustomEvent(eventTarget, eventType) 
    {
        var evt = document.createEvent("HTMLEvents");
        evt.initEvent(eventType, true, true);
        evt.view = window;
        evt.altKey = false;
        evt.ctrlKey = false;
        evt.shiftKey = false;
        evt.metaKey = false;
        eventTarget.dispatchEvent(evt);
    }
    
})();