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
        '2016/06/21',
        '2016/06/22',
        '2016/06/23',
        '2016/06/24',
        '2016/06/25',
        '2016/06/26',
        '2016/06/27',
        '2016/06/28',
        '2016/06/29',
        '2016/06/30',
        '2016/07/01',
        '2016/07/02',
        '2016/07/03',
        '2016/07/04',
        '2016/07/05',
        '2016/07/06',
        '2016/07/07',
        '2016/07/08',
        '2016/07/09',
        '2016/07/10',
        '2016/07/11',
        '2016/07/12',
        '2016/07/13',
        '2016/07/14',
        '2016/07/15',
        '2016/07/16',
        '2016/07/17',
        '2016/07/18',
        '2016/07/19',
        '2016/07/20',
        '2016/07/21',
        '2016/07/22',
        '2016/07/23',
        '2016/07/24',
        '2016/07/25',
        '2016/07/26',
        '2016/07/27',
        '2016/09/07',
        '2016/09/08',
        '2016/09/09',
        '2016/09/10',
        '2016/09/11',
        '2016/09/12',
        '2016/09/13',
        '2016/09/14',
        '2016/09/15',
        '2016/09/16',
        '2016/09/17',
        '2016/09/18',
        '2016/09/19',
        '2016/09/20',
        '2016/09/21',
        '2016/09/22',
        '2016/09/23',
        '2016/09/24',
        '2016/09/25',
        '2016/09/26',
        '2016/09/27',
        '2016/09/28',
        '2016/09/29',
        '2016/09/30',
        '2016/10/09',
        '2016/10/10',
        '2016/10/11',
        '2016/10/12',
        '2016/10/13',
        '2016/10/14',
        '2016/10/15',
        '2016/10/16',
        '2016/10/17',
        '2016/10/18',
        '2016/10/19',
        '2016/10/20',
        '2016/10/21',
        '2016/10/22',
        '2016/10/23',
        '2016/10/24',
        '2016/10/25',
        '2016/10/26',
        '2016/10/27',
        '2016/10/28',
        '2016/10/29',
        '2016/10/30',
        '2016/10/31',
        '2016/11/01',
        '2016/11/02',
        '2016/11/03',
        '2016/11/04',
        '2016/11/05',
        '2016/11/06',
        '2016/11/07',
        '2016/11/08',
        '2016/11/09',
        '2016/11/10',
        '2016/11/18',
        '2016/11/19',
        '2016/11/20',
        '2016/11/21',
        '2016/11/22',
        '2016/11/23',
        '2016/11/24',
        '2016/11/25',
        '2016/11/26',
        '2016/11/27',
        '2016/11/28',
        '2016/11/29',
        '2016/11/30',
        '2016/12/01',
        '2016/12/02',
        '2016/12/03',
        '2016/12/04',
        '2016/12/05',
        '2016/12/06',
        '2016/12/07',
        '2016/12/08',
        '2016/12/09',
        '2016/12/10',
        '2016/12/11',
        '2016/12/12',
        '2016/12/13',
        '2016/12/14',
        '2016/12/15',
        '2016/12/16',
        '2016/12/17',
        '2016/12/18',
        '2016/12/19',
        '2016/12/20',
        '2016/12/21',
        '2016/12/22',
        '2016/12/23',
        '2016/12/24',
        '2016/12/26',
        '2016/12/27',
        '2016/12/28',
        '2016/12/29',
        '2016/12/30',
        '2016/12/31',
        '2017/01/01',
        '2017/01/02',
        '2017/01/03',
        '2017/01/04',
        '2017/01/05',
        '2017/01/06',
        '2017/01/07',
        '2017/01/08',
        '2017/01/09',
        '2017/01/10',
        '2017/01/11',
        '2017/01/12',
        '2017/01/13',
        '2017/01/14',
        '2017/01/15',
        '2017/01/16',
        '2017/01/17',
        '2017/01/18',
        '2017/01/19',
        '2017/01/20',
        '2017/01/21',
        '2017/01/22',
        '2017/01/23',
        '2017/01/24',
        '2017/02/21',
        '2017/02/22',
        '2017/02/23',
        '2017/02/24',
        '2017/02/25',
        '2017/02/26',
        '2017/02/27',
        '2017/02/28',
        '2017/03/01',
        '2017/03/02',
        '2017/03/03',
        '2017/03/04',
        '2017/03/05',
        '2017/03/06',
        '2017/03/07',
        '2017/03/08',
        '2017/03/09',
        '2017/03/10',
        '2017/03/11',
        '2017/03/12',
        '2017/03/13',
        '2017/03/14',
        '2017/03/15',
        '2017/03/16',
        '2017/03/17',
        '2017/03/18',
        '2017/03/19',
        '2017/03/20',
        '2017/03/21',
        '2017/03/22',
        '2017/03/23',
        '2017/03/24',
        '2017/03/25',
        '2017/03/26',
        '2017/03/27',
        '2017/03/28',
        '2017/03/29',
        '2017/03/30',
        '2017/03/31',
        '2017/04/01',
        '2017/04/02',
        '2017/04/03',
        '2017/04/04',
        '2017/04/05',
        '2017/04/06',
        '2017/04/07',
        '2017/04/08',
        '2017/04/09',
        '2017/04/10',
        '2017/04/11',
        '2017/04/12',
        '2017/04/13',
        '2017/04/14',
        '2017/04/15',
        '2017/04/16',
        '2017/04/17',
        '2017/04/18',
        '2017/04/19',
        '2017/04/20',
        '2017/04/21',
        '2017/04/22',
        '2017/04/23',
        '2017/04/24',
        '2017/04/25',
        '2017/04/26',
        '2017/04/27',
        '2017/04/28',
        '2017/04/29',
        '2017/04/30',
        '2017/05/01',
        '2017/05/02',
        '2017/05/03',
        '2017/05/04',
        '2017/05/05',
        '2017/05/06',
        '2017/05/07',
        '2017/05/08',
        '2017/05/09',
        '2017/05/10',
        '2017/05/11',
        '2017/05/12',
        '2017/05/13',
        '2017/05/14',
        '2017/05/15',
        '2017/05/16',
        '2017/05/17',
        '2017/05/18',
        '2017/05/19',
        '2017/05/20',
        '2017/05/21',
        '2017/05/22',
        '2017/05/27',
        '2017/05/28',
        '2017/05/29',
        '2017/05/30',
        '2017/05/31',
        '2017/06/01',
        '2017/06/02',
        '2017/06/03',
        '2017/06/04',
        '2017/06/05',
        '2017/06/08',
        '2017/06/09',
        '2017/06/10',
        '2017/06/11',
        '2017/06/12',
        '2017/06/13',
        '2017/06/14',
        '2017/06/15',
        '2017/06/16',
        '2017/06/21',
        '2017/06/22',
        '2017/06/23',
        '2017/06/24',
        '2017/06/25',
        '2017/06/26',
        '2017/06/27',
        '2017/06/28',
        '2017/06/29',
        '2017/06/30',
        '2017/07/01',
        '2017/07/02',
        '2017/07/03',
        '2017/07/04',
        '2017/07/05',
        '2017/07/06',
        '2017/07/07',
        '2017/07/08',
        '2017/07/09',
        '2017/07/10',
        '2017/07/11',
        '2017/07/12',
        '2017/07/13',
        '2017/07/28',
        '2017/08/03',
        '2017/08/04',
        '2017/08/05',
        '2017/08/06',
        '2017/08/07',
        '2017/08/08',
        '2017/08/09',
        '2017/08/10',
        '2017/08/11',
        '2017/08/12',
        '2017/08/13',
        '2017/08/14',
        '2017/08/15',
        '2017/08/16',
        '2017/08/17',
        '2017/08/18',
        '2017/08/19',
        '2017/08/20',
        '2017/08/21',
        '2017/08/22',
        '2017/08/23',
        '2017/08/24',
        '2017/08/25',
        '2017/08/26',
        '2017/08/27',
        '2017/08/28',
        '2017/08/29',
        '2017/08/30',
        '2017/08/31',
        '2017/09/01',
        '2017/09/02',
        '2017/09/03',
        '2017/09/04',
        '2017/09/05',
        '2017/09/06',
        '2017/09/07',
        '2017/09/08',
        '2017/09/19',
        '2017/09/20',
        '2017/09/21',
        '2017/09/22',
        '2017/09/23',
        '2017/09/24',
        '2017/09/25',
        '2017/09/26',
        '2017/09/27',
        '2017/09/28',
        '2017/09/29',
        '2017/11/14'
    ];

    var data = [
        23.51392201133395,
        11.932530617653873,
        30.537645905838193,
        7.582471395892958,
        5.461985998783866,
        14.082592472475122,
        13.545620847949086,
        13.262821503839598,
        17.93270586586839,
        25.271977295886387,
        6.277713176438953,
        18.449896660969397,
        18.00844533510238,
        29.10729235693452,
        18.457526585130232,
        13.616909464940747,
        13.397464462986138,
        13.96410534996412,
        17.16165296351846,
        18.182564569352387,
        19.217482164069843,
        8.019433830578233,
        6.904604460095211,
        7.869358842536857,
        8.977925853909674,
        9.779398838390195,
        15.98849968587889,
        26.11814824916946,
        28.178025399633466,
        9.406185609894887,
        8.692627740436492,
        27.93203173670555,
        50.28958021824619,
        28.135933462192266,
        20.139380096256904,
        7.431982985222934,
        14.808775783290146,
        4.8657520402602366,
        6.787872561026103,
        5.958600016785998,
        5.890832061980862,
        12.23256108177515,
        10.022387477838578,
        31.675253444586946,
        40.8147262378201,
        52.61596300036962,
        76.47992555007194,
        21.10402774954746,
        4.770083245962362,
        5.2862692561289615,
        7.643135862684743,
        18.03231376592897,
        23.29641357571828,
        39.42266806266034,
        26.935031493952312,
        37.02081144041278,
        13.27969902197936,
        6.803214970112968,
        5.4688586973832685,
        16.730978077016626,
        26.292458807880518,
        13.703914593520215,
        27.218728789370957,
        42.406621047925455,
        23.841067821571187,
        41.73948615780417,
        60.99930719429869,
        44.13903502297518,
        18.423195927515888,
        18.43483670997469,
        21.93391898064831,
        49.366386519332536,
        19.684217743267123,
        6.7895711435866986,
        4.651332123862617,
        7.2564419606942545,
        26.380502189084222,
        19.736811692796916,
        14.832686010443146,
        10.97981386555135,
        5.240068473629485,
        6.441109456021633,
        9.471449018685178,
        7.409536138806394,
        12.857012994411832,
        27.569879446148462,
        37.91770592628571,
        36.74751191950224,
        32.547759661106376,
        10.135413394301912,
        9.737115073189605,
        10.11508402727662,
        33.5988713062109,
        52.480436182841224,
        24.576307279398247,
        34.144276006923,
        11.709037960962354,
        3.650669434020383,
        3.436177033034587,
        10.819557826617261,
        18.361633563521128,
        38.283651543328226,
        72.54384041735355,
        33.62227260846367,
        19.3457944289985,
        24.720833191198558,
        25.981826432569136,
        12.737698785494837,
        37.02927594005103,
        54.48954743674953,
        84.4871459478786,
        23.979273986868442,
        25.381296481756248,
        40.94387878248014,
        22.46617108911887,
        6.4812488869029785,
        16.750149530925366,
        41.76464735425078,
        20.801766955450258,
        30.118500004247085,
        6.937229958770265,
        11.081446546696112,
        53.045135741151675,
        58.73648735833625,
        57.609976374891644,
        66.1376290977495,
        98.07140369345218,
        40.546453613909115,
        46.627935698535865,
        9.946949414689081,
        22.0567714376342,
        7.717429324973073,
        10.007442527716643,
        22.844652566688044,
        15.387407019824847,
        94.78194393126124,
        89.26942048949631,
        76.40555899981284,
        77.82853608182458,
        90.91826431034987,
        149.27858796089316,
        52.871975386948556,
        32.62525004919626,
        33.07236265513547,
        26.982699593914646,
        7.875617541928985,
        15.76562641853477,
        30.857354918798837,
        15.72598084766369,
        2.798536214479526,
        5.506467316546551,
        10.606039240092965,
        18.199283156394902,
        22.103913095834997,
        16.086364758268946,
        12.072623607746616,
        5.409083339213022,
        9.477403570786503,
        8.407451115582026,
        10.783266861827018,
        30.06629699963165,
        21.98472582937926,
        16.853588605110353,
        6.064015681846203,
        11.002985229327608,
        4.732143073666035,
        6.88853831044763,
        22.45437818471167,
        7.045799319603083,
        2.7195956911346815,
        9.759723359186244,
        15.310041528000829,
        13.977933791337747,
        7.496979394415704,
        6.473267935754219,
        2.139900666463866,
        3.4579041817455543,
        4.871115503011089,
        8.475386390111678,
        15.734792207655959,
        2.6470246849040073,
        4.500762522925412,
        7.140828920558171,
        7.890202135167653,
        21.16425971187271,
        15.753766540363925,
        23.728816081218785,
        23.987579917479636,
        19.521274744775585,
        24.129090292838875,
        24.422221005455967,
        16.12215145198876,
        10.759379797709013,
        7.252452812019141,
        3.100578269627488,
        4.532036532060593,
        9.503585550177979,
        28.61235297271426,
        12.64745672097495,
        8.647642696919567,
        8.79324731799802,
        9.692403272642531,
        26.377227666936786,
        45.46222208924557,
        15.17351224285949,
        18.65884954173473,
        7.651370939768817,
        18.69761626261235,
        19.446900652892676,
        8.148864374286982,
        13.973767986076163,
        12.303222883157432,
        12.926134635742617,
        16.488608503796524,
        12.546357446094921,
        17.668818461052876,
        23.15434945889405,
        11.73787455720973,
        10.262327092653107,
        14.577470480864093,
        8.198797901951313,
        16.187962700840114,
        10.127024182572162,
        14.127100185788706,
        7.179624962490277,
        8.009843817109656,
        7.570220969042399,
        13.222017012171388,
        17.22560614706053,
        18.024396851809545,
        17.68849720428337,
        14.061339513970744,
        17.43404795676657,
        56.9254082943217,
        50.65681455715119,
        15.458888801092735,
        12.548149310122858,
        18.364762132713768,
        13.198928047358867,
        11.24526031284031,
        11.910005179802816,
        12.049766244504964,
        7.473425370518164,
        5.653648212093064,
        5.8315492997697715,
        8.184372607884294,
        17.751770406774465,
        21.276754795641878,
        21.8617250042559,
        19.27410216579669,
        10.957114427386385,
        11.567903920788277,
        9.844193561787508,
        18.236267857778184,
        4.973048930214421,
        6.899509652290305,
        12.580836032555156,
        5.271087867812555,
        8.210431650571442,
        6.303871466242046,
        11.15070145499888,
        9.91406501879511,
        5.5768727000043805,
        8.837721086332989,
        7.441610400968329,
        10.540628403702833,
        10.85702205554105,
        7.444255271176734,
        10.670094082953439,
        21.481083227526593,
        22.251861156885493,
        15.709511335296483,
        11.380344686263143,
        6.724396920054621,
        5.585776512182696,
        8.516215784314182,
        7.355675320443395,
        19.83548741549552,
        24.048424819504703,
        24.94762440253446,
        14.48975340769821,
        19.399199495886503,
        18.681507086436223,
        12.672588072355218,
        16.80702336675493,
        24.66888015737092,
        22.805451634305644,
        9.129770019844072,
        10.80479921688561,
        31.335245426094296,
        10.893170244867099,
        17.352071856054327,
        21.289824888501656,
        20.351560008919087,
        0,
        11.128424677024393,
        9.491322044701336,
        10.475190184328707,
        6.216460242130457,
        3.5472128347628544,
        10.003729800628124,
        6.194792471173869,
        17.308765474203923,
        18.33412073118814,
        8.238483731463429,
        8.920640029604956,
        5.907031081901693,
        8.662842205684072,
        11.047251950702224,
        5.823353854837136,
        17.581207175612754,
        12.37687761137358,
        14.030402354194186,
        15.211041467588116,
        17.36752245258643,
        10.43951481046943,
        5.82075650502308,
        5.2378286096219195,
        6.101939663788342,
        5.115990799850741,
        6.351422407451321,
        6.401727901245153,
        16.38818212445441,
        19.144077381181997,
        34.274824461500145,
        25.40404585259253,
        14.804712499713943,
        22.383647786187108,
        11.62432305565185,
        7.503804883785526,
        16.13492256401996,
        48.882864270701866,
        4.420076903336802,
        5.9166076768590585,
        27.116351054853137,
        11.071090125054011,
        14.067141999982937,
        20.037326860793215,
        25.478338788039554,
        14.067199814581436,
        12.510835375511078,
        5.657839705147231,
        14.338314380471664,
        8.67427550609015
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
            text: '站点pm25测量值均方差',
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
            data: date
        },
        yAxis: {
            type: 'value',
            max: 200,
            boundaryGap: [0, '100%']
        },
        dataZoom: [{
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
        }],
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