(function() {
    'use strict';

    var themes,
        selectedThemeIndex,
        instructionsTimeout,
        deck ;

    function init() {

        //touch = require('bespoke-touch')

        //deck = bespoke.from('article', {
        //    keys: true,
        //    scale: true,
        //    bullets: 'li, .bullet',
        //    progress: true,
        //    hash: true,
        //    state: true
        //
        //});

        var deck = bespoke.from('article', [
            //bespoke.plugins.classes(),
            bespoke.themes.cube(),
            bespoke.plugins.keys(),
            bespoke.plugins.touch(),
            bespoke.plugins.scale(),
            bespoke.plugins.state(),
            bespoke.plugins.bullets('li, .bullet'),
            bespoke.plugins.hash(),
            bespoke.plugins.progress(),


        ]);

//        initThemeSwitching();
    }

    init();


}());