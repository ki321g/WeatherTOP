
function showChart(chartNumber) {
    var chartData = getChartData(chartNumber);
    var chartOptions = getChartOptions(chartNumber);
    var chart = getChartType(chartNumber);

    setChartLabel(chartNumber);

    chart.draw(chartData, chartOptions);
}

    function getChartType(chartNumber) {
    if (chartNumber == 4) {
    var chart = new google.visualization.PieChart(document.getElementById("chart"));
}

    if (chartNumber == 1 || chartNumber == 2 || chartNumber == 3) {
    var chart = new google.visualization.LineChart(document.getElementById("chart"));
}


    return chart
}

    function getChartData(chartNumber) {
    // Code to get chart data based on chartNumber

    if (chartNumber == 1) {
    // Create and populate the data table.
    var date = ['2012', '2013', '20014', '2015', '2016'];
    var temperature = [2, 8, 1, 5, 6];

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Date');
    data.addColumn('number', 'Temperature');

    for (i = 0; i < date.length; i++)
    data.addRow([date[i], temperature[i]]);

    return data;
}

    if (chartNumber == 2) {
    // Create and populate the data table.
    var date = ['2001', '2002', '2003', '2004', '2005'];
    var temperature = [5, 3, 2, 4, 1];

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Date');
    data.addColumn('number', 'Temperature');

    for (i = 0; i < date.length; i++)
    data.addRow([date[i], temperature[i]]);

    return data;
}

    if (chartNumber == 3) {
    // Create and populate the data table.
    var date = ['2016', '2017', '2018', '2019', '2020'];
    var pressure = [11, 15, 20, 12, 16];

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Date');
    data.addColumn('number', 'pressure');

    for (i = 0; i < date.length; i++)
    data.addRow([date[i], pressure[i]]);

    return data;
}


    if (chartNumber == 4) {
    /* var direction = ['N', 'S', 'E', 'W', 'SW'];
     var populartiy = [4, 2, 1, 6, 5];

     for (i = 0; i < direction.length; i++)
       data.addRow([direction[i], populartiy[i]]);
   */
    var data = google.visualization.arrayToDataTable([
    ['windDirection', 'populartiy'],
    ['N', 4],
    ['S', 2],
    ['E', 1],
    ['W', 6],
    ['SE', 5]
    ]);

    return data;
}
}

    function getChartOptions(chartNumber) {
    // Code to get chart options based on chartNumber

    if (chartNumber == 1 || chartNumber == 2 || chartNumber == 3) {
    var options = {
    // chartArea: { 'width': '85%', 'height': '80%' },
    legend: { position: 'none' }
};
}

    if (chartNumber == 4) {
    var options = {
    chartArea: { 'width': '100%', 'height': '100%' },
    //  legend: {position: 'right', alignment: 'center'},
    legend: 'none',
    pieSliceText: 'label',
    fontSize: 12,
    is3D: true,
};
}

    return options;
}

    function setChartLabel(chartNumber) {
    switch (chartNumber) {
    case 1:
    document.getElementById("chartLabel").innerHTML = "Temperature";
    break;
    case 2:
    document.getElementById("chartLabel").innerHTML = "Wind Speed";
    break;
    case 3:
    document.getElementById("chartLabel").innerHTML = "Pressure";
    break;
    case 4:
    document.getElementById("chartLabel").innerHTML = "Wind Direction";
    break;
    default:
    document.getElementById("chartLabel").innerHTML = "None";
}

}
