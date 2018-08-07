/*
 * Copyright (c) 2006-2013, JGraph Ltd
 *
 * Defines the startup sequence of the application.
 */
{

    function CommonException(message, code) {
        this.message = message;
        this.code = code;
    }

    //判断浏览器是否支持
    function checkBrowserSupported() {
        if (!mxClient.isBrowserSupported()) {
            mxUtils.error('Browser is not supported!', 200, false);
            return false;
        }
        return true;
    }

    //初始化页面数据
    function intEditorData(container) {
        var model = new mxGraphModel();
        var graph = new mxGraph(container, model);
        graph.graphHandler.scaleGrid = true;
        graph.setPanning(true);

        // Gets the default parent for inserting new cells. This
        // is normally the first child of the root (ie. layer 0).
        var parent = graph.getDefaultParent();

        // Adds cells to the model in a single step
        graph.getModel().beginUpdate();
        try {
            var v1 = graph.insertVertex(parent, null, 'Hello,', 20, 20, 80, 30);
            var v2 = graph.insertVertex(parent, null, 'World!', 200, 150, 80, 30);
            var e1 = graph.insertEdge(parent, null, '', v1, v2);
        }
        finally {
            // Updates the display
            graph.getModel().endUpdate();
        }

    }


    /**
     * Constructs a new application (returns an mxEditor instance)
     */
    function createEditor(config) {
        var editor = null;

        try {
            if (!mxClient.isBrowserSupported()) {
                mxUtils.error('Browser is not supported!', 200, false);
            }
            else {
                mxObjectCodec.allowEval = true;
                var node = mxUtils.load(config).getDocumentElement();
                editor = new mxEditor(node);
                mxObjectCodec.allowEval = false;

                var hideSplash = function () {
                    var splash = document.getElementById('splash');

                    if (splash != null) {
                        try {
                            mxEvent.release(splash);
                            mxEffects.fadeOut(splash, 100, true);
                        }
                        catch (e) {
                            splash.parentNode.removeChild(splash);
                        }
                    }
                }

                // Adds active border for panning inside the container
                editor.graph.createPanningManager = function () {
                    var pm = new mxPanningManager(this);
                    pm.border = 30;

                    return pm;
                };

                editor.graph.allowAutoPanning = true;
                editor.graph.timerAutoScroll = true;

                // Updates the window title after opening new files
                var title = document.title;

                var funct = function (sender) {
                    document.title = title + ' - ' + sender.getTitle();
                };

                editor.addListener(mxEvent.OPEN, funct);

                // Prints the current root in the window title if the
                // current root of the graph changes (drilling).
                editor.addListener(mxEvent.ROOT, funct);
                funct(editor);

                // Displays version in statusbar
                editor.setStatus('mxGraph ' + mxClient.VERSION);

                // Shows the application

                editor.addAction("save2", function (editor) {
                    alert("触发按钮事件save2");
                    editor.save();
                });

                //editor.graph.getModel().test();

                //创建新窗口
                editor.addAction("import...", function (ed) {
                    //editor.ui
                    editor.graph.getModel().beginUpdate();

                    var tb = document.createElement('div');
                    tb.setAttribute("id", "NO.1");
                    tb.setAttribute("name", "张三风");

                    var html = "<div>张三</div><div>李四</div>";
                    tb.appendChild($(html)[0]);
                    tb.appendChild($(html)[1]);

                    tb.subObject = {id: "NO.1", name: "张三"};


                    var mxWindow1 = new mxWindow("title", tb, 120, 120, 200, 200, true, true);
                    //将该窗口放在最上面
                    mxWindow1.activate();
                    mxWindow1.setClosable(true);
                    mxWindow1.setMaximizable(true);
                    mxWindow1.setMinimizable(true);
                    var content = mxWindow1.content;
                    console.log(content.subObject);
                    //显示该窗口
                    mxWindow1.show();

                    editor.graph.getModel().endUpdate();
                });

                editor.dblClickAction = 'zoomIn';

                //var mxEvent = editor.graph.event
                mxEvent.addMouseWheelListener(function (event, b) {
                    /*console.log(event);
                     console.log(b);*/
                    if (b) {//向上划
                        //editor.graph.zoomIn();
                    } else {
                        //editor.graph.zoomOut();
                    }

                });

                hideSplash();

                console.log(editor.templates);
                console.log(editor.graph.getStylesheet());

            }
        }
        catch (e) {
            //hideSplash();

            // Shows an error message if the editor cannot start
            mxUtils.alert('Cannot start application: ' + e.message);
            throw e; // for debugging
        }

        return editor;
    }

}
