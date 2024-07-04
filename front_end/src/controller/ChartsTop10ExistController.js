function ChartsTop10ExistController($http, $scope) {
    $scope.listProductTop10 = [];

    var ADMIN_API = "http://localhost:26382/Assignment-Java5/admin/";

    $http.get(ADMIN_API + "charts/top-10/exist")
        .then(function (response) {
            $scope.listProductTop10 = response.data;
            console.log(response.data);
            Highcharts.chart('container', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'World\'s largest cities per 2021'
                },
                subtitle: {
                    text: 'Source: <a href="https://worldpopulationreview.com/world-cities" target="_blank">World Population Review</a>'
                },
                xAxis: {
                    type: 'category',
                    labels: {
                        rotation: -45,
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Verdana, sans-serif'
                        }
                    }
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Population (millions)'
                    }
                },
                legend: {
                    enabled: false
                },
                tooltip: {
                    pointFormat: 'Population in 2021: <b>{point.y:.1f} millions</b>'
                },
                series: [{
                    name: 'Population',
                    colors: [
                        '#9b20d9', '#9215ac', '#861ec9', '#7a17e6', '#7010f9', '#691af3',
                        '#6225ed', '#5b30e7', '#533be1', '#4c46db', '#4551d5', '#3e5ccf',
                        '#3667c9', '#2f72c3', '#277dbd', '#1f88b7', '#1693b1', '#0a9eaa',
                        '#03c69b', '#00f194'
                    ],
                    colorByPoint: true,
                    groupPadding: 0,
                    data: $scope.listProductTop10.map(function (item) {
                        return {
                            name: item.productName + " " + item.categoryName + " " + item.materialName + " " + item.sizeName + " " + item.colorName,
                            y: item.quantityRun
                        };

                    }),
                    dataLabels: {
                        enabled: true,
                        rotation: -90,
                        color: '#FFFFFF',
                        align: 'right',
                        format: '{point.y:.1f}', // one decimal
                        y: 10, // 10 pixels down from the top
                        style: {
                            fontSize: '12px',
                            fontFamily: 'Verdana, sans-serif'
                        }
                    }
                }]
            });
        });
}
