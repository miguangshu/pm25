<%--
  Created by IntelliJ IDEA.
  User: katiemi
  Date: 2016/11/7
  Time: 下午8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<script src="${pageContext.request.contextPath}/echart/echarts.min.js"></script>
<body>
<div id="div_echart_2" style="width: 100%;height:80%;"></div>
</body>
<script>
    var myChart2 = echarts.init(document.getElementById('div_echart_2'));
    var base = +new Date(1968, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var date = [
        '06/21 16',
        '06/22 16',
        '06/23 16',
        '06/24 16',
        '06/25 16',
        '06/26 16',
        '06/27 16',
        '06/28 16',
        '06/29 16',
        '06/30 16',
        '07/01 16',
        '07/02 16',
        '07/03 16',
        '07/04 16',
        '07/05 16',
        '07/06 16',
        '07/07 16',
        '07/08 16',
        '07/09 16',
        '07/10 16',
        '07/11 16',
        '07/12 16',
        '07/13 16',
        '07/14 16',
        '07/15 16',
        '07/16 16',
        '07/17 16',
        '07/18 16',
        '07/19 16',
        '07/20 16',
        '07/21 16',
        '07/22 16',
        '07/23 16',
        '07/24 16',
        '07/25 16',
        '07/26 16',
        '07/27 16',
        '09/07 16',
        '09/08 16',
        '09/09 16',
        '09/10 16',
        '09/11 16',
        '09/12 16',
        '09/13 16',
        '09/14 16',
        '09/15 16',
        '09/16 16',
        '09/17 16',
        '09/18 16',
        '09/19 16',
        '09/20 16',
        '09/21 16',
        '09/22 16',
        '09/23 16',
        '09/24 16',
        '09/25 16',
        '09/26 16',
        '09/27 16',
        '09/28 16',
        '09/29 16',
        '09/30 16',
        '10/09 16',
        '10/10 16',
        '10/11 16',
        '10/12 16',
        '10/13 16',
        '10/14 16',
        '10/15 16',
        '10/16 16',
        '10/17 16',
        '10/18 16',
        '10/19 16',
        '10/20 16',
        '10/21 16',
        '10/22 16',
        '10/23 16',
        '10/24 16',
        '10/25 16',
        '10/26 16',
        '10/27 16',
        '10/28 16',
        '10/29 16',
        '10/30 16',
        '10/31 16',
        '11/01 16',
        '11/02 16',
        '11/03 16',
        '11/04 16',
        '11/05 16',
        '11/06 16',
        '11/07 16',
        '11/08 16',
        '11/09 16',
        '11/10 16',
        '11/18 16',
        '11/19 16',
        '11/20 16',
        '11/21 16',
        '11/22 16',
        '11/23 16',
        '11/24 16',
        '11/25 16',
        '11/26 16',
        '11/27 16',
        '11/28 16',
        '11/29 16',
        '11/30 16',
        '12/01 16',
        '12/02 16',
        '12/03 16',
        '12/04 16',
        '12/05 16',
        '12/06 16',
        '12/07 16',
        '12/08 16',
        '12/09 16',
        '12/10 16',
        '12/11 16',
        '12/12 16',
        '12/13 16',
        '12/14 16',
        '12/15 16',
        '12/16 16',
        '12/17 16',
        '12/18 16',
        '12/19 16',
        '12/20 16',
        '12/21 16',
        '12/22 16',
        '12/23 16',
        '12/24 16',
        '12/26 16',
        '12/27 16',
        '12/28 16',
        '12/29 16',
        '12/30 16',
        '12/31 16',
        '01/01 17',
        '01/02 17',
        '01/03 17',
        '01/04 17',
        '01/05 17',
        '01/06 17',
        '01/07 17',
        '01/08 17',
        '01/09 17',
        '01/10 17',
        '01/11 17',
        '01/12 17',
        '01/13 17',
        '01/14 17',
        '01/15 17',
        '01/16 17',
        '01/17 17',
        '01/18 17',
        '01/19 17',
        '01/20 17',
        '01/21 17',
        '01/22 17',
        '01/23 17',
        '01/24 17',
        '02/21 17',
        '02/22 17',
        '02/23 17',
        '02/24 17',
        '02/25 17',
        '02/26 17',
        '02/27 17',
        '02/28 17',
        '03/01 17',
        '03/02 17',
        '03/03 17',
        '03/04 17',
        '03/05 17',
        '03/06 17',
        '03/07 17',
        '03/08 17',
        '03/09 17',
        '03/10 17',
        '03/11 17',
        '03/12 17',
        '03/13 17',
        '03/14 17',
        '03/15 17',
        '03/16 17',
        '03/17 17',
        '03/18 17',
        '03/19 17',
        '03/20 17',
        '03/21 17',
        '03/22 17',
        '03/23 17',
        '03/24 17',
        '03/25 17',
        '03/26 17',
        '03/27 17',
        '03/28 17',
        '03/29 17',
        '03/30 17',
        '03/31 17',
        '04/01 17',
        '04/02 17',
        '04/03 17',
        '04/04 17',
        '04/05 17',
        '04/06 17',
        '04/07 17',
        '04/08 17',
        '04/09 17',
        '04/10 17',
        '04/11 17',
        '04/12 17',
        '04/13 17',
        '04/14 17',
        '04/15 17',
        '04/16 17',
        '04/17 17',
        '04/18 17',
        '04/19 17',
        '04/20 17',
        '04/21 17',
        '04/22 17',
        '04/23 17',
        '04/24 17',
        '04/25 17',
        '04/26 17',
        '04/27 17',
        '04/28 17',
        '04/29 17',
        '04/30 17',
        '05/01 17',
        '05/02 17',
        '05/03 17',
        '05/04 17',
        '05/05 17',
        '05/06 17',
        '05/07 17',
        '05/08 17',
        '05/09 17',
        '05/10 17',
        '05/11 17',
        '05/12 17',
        '05/13 17',
        '05/14 17',
        '05/15 17',
        '05/16 17',
        '05/17 17',
        '05/18 17',
        '05/19 17',
        '05/20 17',
        '05/21 17',
        '05/22 17',
        '05/27 17',
        '05/28 17',
        '05/29 17',
        '05/30 17',
        '05/31 17',
        '06/01 17',
        '06/02 17',
        '06/03 17',
        '06/04 17',
        '06/05 17',
        '06/08 17',
        '06/09 17',
        '06/10 17',
        '06/11 17',
        '06/12 17',
        '06/13 17',
        '06/14 17',
        '06/15 17',
        '06/16 17',
        '06/21 17',
        '06/22 17',
        '06/23 17',
        '06/24 17',
        '06/25 17',
        '06/26 17',
        '06/27 17',
        '06/28 17',
        '06/29 17',
        '06/30 17',
        '07/01 17',
        '07/02 17',
        '07/03 17',
        '07/04 17',
        '07/05 17',
        '07/06 17',
        '07/07 17',
        '07/08 17',
        '07/09 17',
        '07/10 17',
        '07/11 17',
        '07/12 17',
        '07/13 17',
        '07/28 17',
        '08/03 17',
        '08/04 17',
        '08/05 17',
        '08/06 17',
        '08/07 17',
        '08/08 17',
        '08/09 17',
        '08/10 17',
        '08/11 17',
        '08/12 17',
        '08/13 17',
        '08/14 17',
        '08/15 17',
        '08/16 17',
        '08/17 17',
        '08/18 17',
        '08/19 17',
        '08/20 17',
        '08/21 17',
        '08/22 17',
        '08/23 17',
        '08/24 17',
        '08/25 17',
        '08/26 17',
        '08/27 17',
        '08/28 17',
        '08/29 17',
        '08/30 17',
        '08/31 17',
        '09/01 17',
        '09/02 17',
        '09/03 17',
        '09/04 17',
        '09/05 17',
        '09/06 17',
        '09/07 17',
        '09/08 17',
        '09/19 17',
        '09/20 17',
        '09/21 17',
        '09/22 17',
        '09/23 17',
        '09/24 17',
        '09/25 17',
        '09/26 17',
        '09/27 17',
        '09/28 17',
        '09/29 17',
        '11/14 17'
    ];

    var data = [
        32.35512581750636,
        20.599336782312612,
        38.555988173755615,
        14.142497174049575,
        9.834921575087286,
        14.687740398761958,
        18.743262356831224,
        33.16241317615312,
        21.03835891446962,
        33.242198913132185,
        10.151919821169322,
        28.40835316101566,
        25.46025951031454,
        53.643186635207925,
        25.794392460147552,
        24.426599142322747,
        20.11816430683139,
        28.760255880563367,
        23.590631740208263,
        36.39412468728851,
        26.663894387146232,
        15.55388464867857,
        8.955791062311299,
        10.377647996462185,
        12.885436970756022,
        11.486744553774708,
        26.576787188897576,
        29.448040104092204,
        36.77944011720637,
        35.579402496414126,
        19.136045441513684,
        30.42883509792944,
        56.61914271735854,
        41.062863339758984,
        24.63570124532211,
        12.0599145465297,
        15.32022984538522,
        17.440372622803185,
        9.708064468340261,
        8.937032573246993,
        10.386692406506342,
        26.84736861919044,
        12.411176992234127,
        29.496469938015405,
        36.3392683775455,
        42.6539523642947,
        56.4732212458431,
        22.73161912263418,
        5.358213811235382,
        8.642193008721799,
        11.08385328423934,
        27.09748164206695,
        30.09085313704869,
        48.735251087809345,
        72.90392712785489,
        51.69240685260535,
        28.79801056195356,
        29.47542898533623,
        10.817536559782095,
        26.437869154749833,
        27.24220279967619,
        16.555050361153167,
        47.70054160376132,
        46.77943499225323,
        30.948620608571588,
        60.38443814335046,
        79.0916968822989,
        56.26984892851149,
        28.657594176641147,
        37.01987912753478,
        44.34758325356749,
        63.971967732402575,
        84.34173325049221,
        9.66796087090166,
        8.35705508359478,
        9.95779517277455,
        25.91475653769738,
        31.0844688052834,
        42.389070918496586,
        14.063728941499447,
        7.568446857756839,
        12.0682197147439,
        27.37985314298612,
        8.457462418625006,
        23.017094603596906,
        36.06145072905988,
        75.40818826076402,
        55.669959354374846,
        43.14336238498275,
        30.16215799608363,
        36.328944841738036,
        27.348348819622043,
        61.053055500421124,
        62.54912729700779,
        26.23443917905966,
        84.68254585242823,
        28.05634652142408,
        4.057166489415918,
        4.411322708243577,
        15.437623003333636,
        53.52285076139484,
        73.29490099643556,
        80.51170711541825,
        104.60455317917108,
        29.260154879781417,
        37.84143797005146,
        56.786426141835975,
        32.53383636734232,
        58.703389603213154,
        118.54445276808016,
        146.9800067484588,
        71.88827345633987,
        43.89909120167903,
        57.150365734844975,
        92.09489201797498,
        17.904257923038625,
        22.61351573174767,
        60.40558646800155,
        91.45785342983437,
        74.49675483535665,
        21.392558680478373,
        29.170962887048752,
        83.48752488287757,
        96.87627493288934,
        64.31257514268525,
        80.01401786909314,
        106.22200969140974,
        52.19579226970923,
        158.24043671790133,
        24.045899057836976,
        22.269835103914794,
        10.849046688947231,
        35.51481430485066,
        65.87257084550079,
        52.689597387335446,
        120.27428144777176,
        110.6356135815828,
        90.22689531623395,
        150.1308816859559,
        118.44491140000396,
        173.40020213317615,
        78.24013681360503,
        38.38067163118839,
        55.85371196904866,
        49.118123792308545,
        33.40636025487355,
        36.48132459589202,
        33.32678158268095,
        32.402111115911964,
        3.477605202387534,
        12.840320499748652,
        20.29846737509455,
        24.794697138155158,
        30.21784253268666,
        32.32421723652086,
        43.114792918920024,
        16.921668649637283,
        30.986920209255754,
        19.35697308272019,
        20.333930705686804,
        34.235601190703385,
        24.786901699643074,
        49.501916797125205,
        11.311162934250143,
        20.448595593057107,
        5.855042894422264,
        13.563816909239689,
        25.559857493815702,
        11.609490662277151,
        3.967533168663426,
        20.26263472052101,
        19.614691206111573,
        36.55132782775781,
        22.986193722958042,
        11.436418437022434,
        2.487272288572363,
        4.347520346096407,
        7.269781144019703,
        16.852801757670246,
        37.41368087464137,
        2.940213728767578,
        7.302689254725291,
        17.431014823520105,
        16.20516531550208,
        26.97942116103335,
        34.57546485676986,
        36.16945073769665,
        37.57051754474839,
        57.773165109511126,
        28.62270004473864,
        33.3543676399895,
        39.14809449346334,
        14.875213567690851,
        19.214401859327506,
        3.911110633747655,
        7.720923152122916,
        14.874266876191466,
        34.117969332953,
        33.98176434736316,
        18.64006835924962,
        20.092224432324283,
        12.639117347599427,
        49.217064565498504,
        61.474560271680794,
        19.234661999167603,
        29.208342414274487,
        26.525559598578635,
        40.48542023424249,
        22.938271591960532,
        13.440185544876597,
        29.747392477023904,
        18.48553718117337,
        18.176326536344124,
        28.155062808106024,
        15.315376713907135,
        50.56285297084177,
        54.015858327963606,
        12.791500783096199,
        14.820550421476424,
        25.655750707536964,
        10.10420186610898,
        18.88865368266549,
        17.502280219611464,
        25.154935601349198,
        9.0147341668385,
        9.077459449742996,
        9.154829958726644,
        15.036427988942943,
        19.835492302522457,
        22.77856333613695,
        22.702976772242607,
        31.133823980676098,
        34.4845868236095,
        186.47493379315017,
        173.93271431307582,
        17.076243399437743,
        16.42957190102896,
        24.177914847191126,
        17.037562540644977,
        16.811058198652688,
        17.171874210140516,
        15.2460968080996,
        12.930032940118977,
        7.429448905130894,
        10.864378038612932,
        12.314972706363895,
        21.898710419480544,
        24.839377257379763,
        37.85507563779541,
        22.625540396637287,
        14.811052763075876,
        19.63293069290962,
        15.30736932185134,
        43.01000278430788,
        9.865941085331317,
        11.12147876678692,
        30.1716537771362,
        7.147230184173137,
        9.002597763593313,
        11.10733822662792,
        17.47925338771105,
        10.240764809763423,
        6.819568198696063,
        10.653999436505316,
        7.293840783749314,
        12.001108988176387,
        11.22970711279152,
        10.325601946402708,
        15.264422192685283,
        14.973651451411362,
        21.078501143670856,
        20.584809326296902,
        15.681530795597684,
        10.396126067179765,
        7.814097658861333,
        10.495208242451932,
        8.035561393803189,
        34.041402242955066,
        41.987204932464394,
        42.66283459353768,
        21.32081587711964,
        24.257496087718206,
        42.188087987443396,
        17.871354401939485,
        15.740119790953552,
        26.10003978044172,
        43.282081206593475,
        15.328871552672942,
        24.79181434123026,
        31.35953383987589,
        10.473805223054326,
        22.42856649194921,
        25.722120830133765,
        19.77195899890349,
        0,
        12.80389991667448,
        11.972770495308653,
        15.739579886388327,
        9.53680659667895,
        4.899606204074424,
        11.781480721108844,
        11.667320303413403,
        22.07527368648764,
        35.331188378570566,
        10.788069027093465,
        15.749944885265123,
        6.9115067131497225,
        14.661757063237879,
        32.093777299935596,
        8.414145030182922,
        24.5557044741588,
        16.386920258412058,
        15.757043641167744,
        20.676050921932717,
        27.242279931865728,
        18.30552921090669,
        9.78479546144027,
        6.039519614415748,
        6.878829600348465,
        7.157173241923297,
        11.03696220712949,
        11.409049471603511,
        19.857153533158353,
        30.435927137997734,
        39.08215429004162,
        54.83647354834886,
        16.937716483264076,
        26.873664049482404,
        33.333832115768786,
        9.286549412995116,
        33.969288216186435,
        37.42806142322952,
        5.562360387121345,
        8.801441456902038,
        27.806753020551543,
        19.580200067769404,
        22.26295473144942,
        28.204449816294126,
        30.550656369976302,
        51.54131485699805,
        13.851546611263215,
        6.806187745225954,
        11.87054009816833,
        5.024765058078724,
        2.7182510717166823

    ];

    /*for (var i = 1; i < 350; i++) {
        var now = new Date(base += oneDay);
//        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
        date.push(i);
//        data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
    }*/

    option = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '',
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date,
            axisLabel: {
                show: true,
                textStyle: {
                    fontSize:'30'
                }
            }
        },
        yAxis: {
            type: 'value',
            max: 200,
            boundaryGap: [0, '100%'],
            axisLabel: {
                show: true,
                textStyle: {
                    fontSize:'30'
                }
            }
        },
        /*dataZoom: [{
            type: 'inside',
            start: 0,
            end: 10
        }, {
            start: 0,
            end: 10,
            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
            handleSize: '80%',
            handleStyle: {
                color: '#fff',
                shadowBlur: 3,
                shadowColor: 'rgba(0, 0, 0, 0.6)',
                shadowOffsetX: 2,
                shadowOffsetY: 2
            }
        }],*/
        series: [
            {
                name:'均方差',
                type:'line',
                smooth:true,
                symbol: 'none',
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: 'rgb(114, 206, 255)'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#2378f7'},
                                    {offset: 0.7, color: '#2378f7'},
                                    {offset: 1, color: '#83bff6'}
                                ]
                        )
                    }
                },
                data: data
            }
        ]
    };
    myChart2.setOption(option);
</script>
</html>
